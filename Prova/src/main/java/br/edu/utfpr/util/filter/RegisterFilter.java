package br.edu.utfpr.util.filter;

import br.edu.utfpr.model.UserBean;
import br.edu.utfpr.util.filter.entityManager.ManagerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "RegisterFilter",
        urlPatterns = {"/cadastrar/salvar"},
        dispatcherTypes = DispatcherType.REQUEST)
public class RegisterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String confirm_password = req.getParameter("confirm_password");

        if (!validUser(name, password, confirm_password, (HttpServletRequest) req)) {
            ((HttpServletResponse) resp).sendRedirect("/cadastrar");
        } else {
            chain.doFilter(req, resp);
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }


    private boolean validUser(String name, String password, String confirm, HttpServletRequest req) {
        if (name == null || password == null || confirm == null) {
            req.getServletContext().setAttribute("invalid", "Nome de usuário e/ou senha inválidos");
            req.getServletContext().setAttribute("name", name);
            return false;
        }

        if (name.trim().equals("") || password.trim().equals("") || confirm.trim().equals("")) {
            req.getServletContext().setAttribute("invalid", "Nome de usuário e/ou senha inválidos");
            req.getServletContext().setAttribute("name", name);
            return false;
        }

        if (!password.equals(confirm)) {
            req.getServletContext().setAttribute("invalid", "Senha não confere");
            req.getServletContext().setAttribute("name", name);
            return false;
        }

        EntityManager em = ManagerFactory.getManagerFactory().createEntityManager();

        Query query = em.createQuery("SELECT users from UserBean users WHERE users.name = :name");
        query.setParameter("name", name);

        boolean isEmpty = query.getResultList().isEmpty();

        em.close();

        if (!isEmpty) {
            req.getServletContext().setAttribute("invalid", "Nome de usuário já utilizado");
            req.getServletContext().setAttribute("name", name);
        }

        return isEmpty;

    }
}
