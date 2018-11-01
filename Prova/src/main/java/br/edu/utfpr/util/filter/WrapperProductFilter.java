package br.edu.utfpr.util.filter;

import br.edu.utfpr.util.filter.Wrapper.WrappedProduct;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebFilter(filterName = "WrapperProductFilter",
        urlPatterns = {"/online/produto/criar", "/online/produto/editar"})
public class WrapperProductFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequestWrapper request = new WrappedProduct((HttpServletRequest) req);

        if (((HttpServletRequest) req).getMethod().equalsIgnoreCase("POST")) {
            String description = req.getParameter("description");
            String validity = req.getParameter("validity");
            String quantity = req.getParameter("quantity");
            String title = req.getParameter("title");
            String price = req.getParameter("price");

            if (!isValidParams(description, validity, quantity, title, price)) {
                if (request.getRequestURI().contains("criar"))
                    ((HttpServletResponse) resp).sendRedirect("/online/produto/criar");
                else
                    ((HttpServletResponse) resp).sendRedirect("/online/produto/editar");

            } else {
                chain.doFilter(request, resp);
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

    private boolean isValidParams(String desc, String val, String quant, String title, String price) {
        boolean titleValid = title != null && !title.trim().equals("");
        boolean descValid = desc != null && !desc.trim().equals("");

        int quantity = 0;
        try {
            quantity = Integer.parseInt(quant);
        } catch (Exception e) {
        }

        boolean quantityValid = quant != null && quantity > 0;

        boolean validDate = false;
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Date date = format.parse(val);
            Date today = new Date();
            validDate = date.after(today);
        } catch (ParseException e) {
        }

        boolean validPrice = false;
        try {
            String replaced = price.replace("R$ ", "");
            replaced = replaced.replace(".", "");
            replaced = replaced.replace(",", ".");

            double formattedPrice = Double.parseDouble(replaced);

            validPrice = true;
        } catch (Exception e) {
        }

        return titleValid && descValid && quantityValid && validDate && validPrice;
    }

}
