package br.edu.utfpr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

@WebServlet("/online/produto")
public class UserProductsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentUser = request.getSession().getAttribute("user").toString();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("prova");
        EntityManager em = entityManagerFactory.createEntityManager();

        Query query = em.createQuery("SELECT products FROM ProductBean products WHERE products.user.name = :name ORDER BY products.title");
        query.setParameter("name", currentUser);

        List products = query.getResultList();

        request.setAttribute("products", products);
        request.setAttribute("breadcrumb", "Meus Produtos");

        request.getRequestDispatcher("/WEB-INF/view/product/user-products.jsp").forward(request, response);
    }
}
