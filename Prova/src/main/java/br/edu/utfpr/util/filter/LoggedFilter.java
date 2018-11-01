package br.edu.utfpr.util.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static javax.swing.text.html.CSS.getAttribute;

@WebFilter(filterName = "LoggedFilter")
public class LoggedFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = ((HttpServletRequest) req);
        HttpSession session = request.getSession();

        if (request.getUserPrincipal() != null) {
            Cookie[] cookies = request.getCookies();
            SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss");
            String time = fmt.format(new Date());

            boolean hasCookies = false;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("currentTime")) {
                    cookie.setValue(time);
                    cookie.setMaxAge(-1);
                    ((HttpServletResponse) resp).addCookie(cookie);
                    hasCookies = true;
                }
            }
            if (!hasCookies) {
                Cookie currentTime = new Cookie("currentTime", time);
                currentTime.setMaxAge(-1);
                ((HttpServletResponse) resp).addCookie(currentTime);
            }

            session.setAttribute("user", request.getUserPrincipal().getName());
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
