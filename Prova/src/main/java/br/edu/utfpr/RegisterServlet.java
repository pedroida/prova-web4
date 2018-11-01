package br.edu.utfpr;

import br.edu.utfpr.model.UserBean;
import br.edu.utfpr.model.UserRoleBean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet({"/cadastrar", "/cadastrar/salvar"})
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prova");
        EntityManager em = emf.createEntityManager();

        String encodedPassword = hashWith256(request.getParameter("password"));

        UserBean user = new UserBean(request.getParameter("name"), encodedPassword);
        UserRoleBean role = new UserRoleBean(user.getName(), "user");

        em.getTransaction().begin();
        em.merge(user);
        em.merge(role);
        em.getTransaction().commit();


        em.close();
        emf.close();

        request.login(user.getName(), request.getParameter("password"));
        request.getServletContext().setAttribute("success", "Cadastro realizado com sucesso");
        request.getSession().setAttribute("user", request.getUserPrincipal().getName());

        response.sendRedirect("/online/index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/online/index");
        } else {
            request.setAttribute("breadcrumb", "Cadastre-se");
            request.getRequestDispatcher("/WEB-INF/view/registrar.jsp").forward(request, response);
        }
    }

    private String hashWith256(String textToHash) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(textToHash.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }
}
