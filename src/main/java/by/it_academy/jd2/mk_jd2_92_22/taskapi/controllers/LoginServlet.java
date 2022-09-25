package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.UserService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.exception.EntityNotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/api/login")
public class LoginServlet extends HttpServlet {
    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        final boolean isLogin = userService.login(login, password);
        if (isLogin) {
            User user = userService.getByLogin(login);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/api/message");
        } else {
            throw new EntityNotFoundException("Specified user is not exist");
        }
    }
}