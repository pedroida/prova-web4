package br.edu.utfpr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/index", ""})
public class ProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int counter = 1;

        request.setAttribute("counter", counter);
        request.getRequestDispatcher("/WEB-INF/view/product/index.jsp").forward(request, response);
//        response.sendRedirect();
    }
}
