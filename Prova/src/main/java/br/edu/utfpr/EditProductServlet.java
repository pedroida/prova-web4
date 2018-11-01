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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "EditProductServlet", urlPatterns = "/online/produto/editar")
public class EditProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getManagerFactory().createEntityManager();

        ProductBean product = em.find(ProductBean.class, Integer.parseInt(request.getParameter("id")));

        double price = Double.parseDouble(request.getParameter("price"));
        float quantity = Float.parseFloat(request.getParameter("quantity"));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date validity = new Date();
        try {
            validity = format.parse(request.getParameter("validity"));
        } catch (ParseException e) {

        }

        em.getTransaction().begin();
        product.setTitle(request.getParameter("title"));
        product.setDescription(request.getParameter("description"));
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setValidity(validity);
        product.setUnit(request.getParameter("unit"));
        em.getTransaction().commit();

        em.close();

        request.getServletContext().setAttribute("success", "Produto editado com sucesso");

        response.sendRedirect("/online/produto");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = ManagerFactory.getManagerFactory().createEntityManager();

        ProductBean product = em.find(ProductBean.class, Integer.parseInt(request.getParameter("id")));

        request.setAttribute("product", product);
        request.setAttribute("breadcrumb", "Edição de produto");
        request.setAttribute("action", "/online/produto/editar");
        request.getRequestDispatcher("/WEB-INF/view/product/edit.jsp").forward(request, response);

        em.close();
    }
}
