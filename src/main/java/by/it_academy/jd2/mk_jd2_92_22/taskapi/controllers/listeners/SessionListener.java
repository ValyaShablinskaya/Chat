package by.it_academy.jd2.mk_jd2_92_22.taskapi.controllers.listeners;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.StatisticService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IStatisticService;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {
    private final IStatisticService statisticService;

    public SessionListener() {
        this.statisticService = StatisticService.getInstance();
    }
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        this.statisticService.incSessionCount();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        this.statisticService.decSessionCount();

    }
}
