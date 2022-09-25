package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IoSignUpServlet", urlPatterns = "/ui/signUp")
public class UiSignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }
}
