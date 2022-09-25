package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "UserServlet", urlPatterns = "/api/user")
public class UserServlet extends HttpServlet {
    private final UserService userService =UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String birthday = req.getParameter("birthday");
        LocalDate date = LocalDate.parse(birthday);

        User user = User.builder()
                .login(login)
                .password(password)
                .fullName(fullName)
                .birthday(date)
                .build();

        userService.add(user);
        resp.sendRedirect("/api/login");
    }
}
