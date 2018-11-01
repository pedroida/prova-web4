package br.edu.utfpr.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "UnauthenticatedFilter",
        dispatcherTypes = DispatcherType.REQUEST,
        urlPatterns = {"/", "/login", "/cadastrar", "/cadastrar/salvar"})
public class UnauthenticatedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = ((HttpServletRequest) req);

        if (request.getUserPrincipal() == null) {
            chain.doFilter(req, resp);
        } else {
            ((HttpServletResponse)resp).sendRedirect("/online/index");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
