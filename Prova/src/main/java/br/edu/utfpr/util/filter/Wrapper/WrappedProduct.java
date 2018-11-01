package br.edu.utfpr.util.filter.Wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class WrappedProduct extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public WrappedProduct(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        if (name.equals("price")) {
            String replace = super.getParameter(name).replace("R$ ", "");
            replace = replace.replace(".", "");
            replace = replace.replace(",", ".");
            return replace;
        }
        
        if (name.equals("quantity")) {
            return String.valueOf(Float.parseFloat(super.getParameter(name)));
        }

        return super.getParameter(name);
    }

    @Override
    public void setAttribute(String name, Object o) {
        super.setAttribute(name, o);
    }
}
