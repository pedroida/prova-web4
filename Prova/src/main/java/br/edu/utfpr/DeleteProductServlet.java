package br.edu.utfpr;

import br.edu.utfpr.model.ProductBean;
import br.edu.utfpr.util.filter.entityManager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", urlPatterns = "/online/produto/apagar")
public class DeleteProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getManagerFactory().createEntityManager();

        ProductBean productBean = em.find(ProductBean.class, Integer.parseInt(request.getParameter("id")));

        em.getTransaction().begin();
        em.remove(productBean);
        em.getTransaction().commit();

        em.close();

        request.getServletContext().setAttribute("success", "Produto removido com sucesso");

        response.sendRedirect("/online/produto");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
