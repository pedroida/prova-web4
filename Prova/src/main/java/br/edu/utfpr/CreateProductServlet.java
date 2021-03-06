package br.edu.utfpr;

import br.edu.utfpr.model.ProductBean;
import br.edu.utfpr.model.UserBean;
import br.edu.utfpr.util.filter.entityManager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet({"/online/produto/criar"})
public class CreateProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getManagerFactory().createEntityManager();

        Query query = em.createQuery("SELECT users from UserBean users WHERE users.name = :name");
        query.setParameter("name", request.getSession().getAttribute("user"));

        UserBean user = (UserBean) query.getSingleResult();

        double price = Double.parseDouble(request.getParameter("price"));
        float quantity = Float.parseFloat(request.getParameter("quantity"));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date validity = new Date();
        try {
            validity = format.parse(request.getParameter("validity"));
        } catch (ParseException e) {

        }

        ProductBean productBean = new ProductBean(
                request.getParameter("title"),
                request.getParameter("description"),
                user,
                quantity,
                price,
                validity,
                request.getParameter("unit")
        );

        em.getTransaction().begin();
        em.merge(productBean);
        em.getTransaction().commit();

        em.close();

        request.getServletContext().setAttribute("success", "Produto cadastrado com sucesso!");
        response.sendRedirect("/online/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("breadcrumb", "Criação de produto");
        request.setAttribute("action", "/online/produto/criar");
        request.getRequestDispatcher("/WEB-INF/view/product/create.jsp").forward(request, response);
    }
}
