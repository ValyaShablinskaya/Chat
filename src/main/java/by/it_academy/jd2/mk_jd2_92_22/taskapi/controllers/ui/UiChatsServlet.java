package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers.ui;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Message;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.MessageService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IMessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UiChatsServlet", urlPatterns = "/ui/user/chats")
public class UiChatsServlet extends HttpServlet {
private final IMessageService messageService;

public UiChatsServlet() {
    this.messageService = MessageService.getInstance();
}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        if(user == null){
            throw new SecurityException("Security bug");
        }

        List<Message> messages = this.messageService.getToWhom(user);

        req.setAttribute("messages", messages);
        req.getRequestDispatcher("/views/chats.jsp").forward(req, resp);
    }
}

