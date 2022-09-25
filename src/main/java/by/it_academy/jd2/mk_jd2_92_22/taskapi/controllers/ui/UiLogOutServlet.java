package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UiLogOutServlet", urlPatterns = "/ui/logOut")
public class UiLogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath() + "/ui");
    }
}

