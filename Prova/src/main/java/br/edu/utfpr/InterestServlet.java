package br.edu.utfpr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InterestServlet", urlPatterns = "/online/produto/interesse/*")
public class InterestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();

        boolean existsCookie = false;

        String user = request.getSession().getAttribute("user").toString() + "-interest";

        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(user)) {
                int counter = Integer.parseInt(cookie.getValue());
                counter++;
                cookie.setValue(String.valueOf(counter));
                response.addCookie(cookie);
                existsCookie = true;

                request.getServletContext().setAttribute(user, counter);
            }
        }

        if (!existsCookie) {
            Cookie cookie = new Cookie(user, "1");
            cookie.setMaxAge(60 * 60 * 24);
            response.addCookie(cookie);
            request.getServletContext().setAttribute(user, cookie.getValue());

        }

        request.getServletContext().setAttribute("success", "Interesse adicionado com sucesso");
        response.sendRedirect("/online/index");
    }
}
