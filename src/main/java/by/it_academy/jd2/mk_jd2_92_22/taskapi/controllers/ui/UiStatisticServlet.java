package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers.ui;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.StatisticService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IStatisticService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UiStatisticServlet", urlPatterns = "/ui/admin/statistics")
public class UiStatisticServlet extends HttpServlet {
    private final IStatisticService statisticService;

    public UiStatisticServlet() {
        this.statisticService = StatisticService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        req.setAttribute("data", statisticService.getData());
        req.getRequestDispatcher("/statistics.jsp").forward(req, resp);
    }
}
