package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {"/ui/user/*", "/api/message"})
public class AdminSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contexPath = req.getContextPath();
        HttpSession session = req.getSession();
        if (session != null && session.getAttribute("user") != null) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(req.getContextPath() + "/ui/singIn");
        }
    }

    @Override
    public void destroy() {

    }
}
