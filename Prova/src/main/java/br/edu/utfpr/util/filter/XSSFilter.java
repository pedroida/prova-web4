package br.edu.utfpr.util.filter;

import br.edu.utfpr.util.filter.Wrapper.XSSRequestWrapper;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class SanitizerFilter
 */

@WebFilter(urlPatterns = {"/*"}, dispatcherTypes = {
        DispatcherType.REQUEST, DispatcherType.FORWARD})
public class XSSFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        chain.doFilter(new XSSRequestWrapper((HttpServletRequest) request), response);
    }

    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

}
