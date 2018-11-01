package br.edu.utfpr;

import br.edu.utfpr.util.filter.entityManager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/online/index"})
public class ProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getManagerFactory().createEntityManager();

        String breadcrumb = "Produtos";

        if (request.getServletContext().getAttribute("success") != null) {
            request.setAttribute("success", request.getServletContext().getAttribute("success"));
        }

        Query query = em.createQuery("SELECT products FROM ProductBean products ORDER BY products.title");

        List products = query.getResultList();

        em.close();

        String userCookie = request.getSession().getAttribute("user").toString() + "-interest";

        if (request.getServletContext().getAttribute(userCookie) == null) {
            updateCookie(request, response);
        }

        request.setAttribute("products", products);
        request.setAttribute("breadcrumb", breadcrumb);
        request.setAttribute("interest", request.getServletContext().getAttribute(userCookie));

        request.getRequestDispatcher("/WEB-INF/view/product/index.jsp").forward(request, response);
    }

    private void updateCookie(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();

        String user = request.getSession().getAttribute("user").toString() + "-interest";
        boolean exists = false;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase(user)) {
                int counter = Integer.parseInt(cookie.getValue());
                request.getServletContext().setAttribute(user, counter);
                exists = true;
            }
        }

        if (!exists) {
            request.getServletContext().setAttribute(user, 0);
        }
    }
}
