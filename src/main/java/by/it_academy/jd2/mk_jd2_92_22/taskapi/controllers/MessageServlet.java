package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Message;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.MessageService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {
    private final MessageService messageService = MessageService.getInstance();
    private final UserService userService =UserService.getInstance();
    private User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        final HttpSession session = req.getSession();
        user = (User) session.getAttribute("user");
        req.setAttribute("messages", messageService.getToWhom(user));
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String login = req.getParameter("login");
        String message = req.getParameter("message");
     User userWhom = userService.getByLogin(login);

        Message messages = Message.builder()
                .fromWhom(user)
                .toWhom(userWhom)
                .text(message)
                .build();
        messageService.add(messages);
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }
}
