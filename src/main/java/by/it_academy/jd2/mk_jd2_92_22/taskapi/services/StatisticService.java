package by.it_academy.jd2.mk_jd2_92_22.taskapi.services;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IMessageService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IStatisticService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IUserService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class StatisticService implements IStatisticService {
    private final static StatisticService instance = new StatisticService();
    private final AtomicLong sessionCounter;
    private final IUserService userService;
    private final IMessageService messageService;

    private StatisticService() {
        this.sessionCounter = new AtomicLong(0);
        this.userService = UserService.getInstance();
        this.messageService = MessageService.getInstance();
    }

    @Override
    public long incSessionCount() {
        return this.sessionCounter.incrementAndGet();
    }

    @Override
    public long decSessionCount() {
        return this.sessionCounter.decrementAndGet();
    }

    @Override
    public long getSessionCount() {
        return this.sessionCounter.get();
    }

    @Override
    public Map<String, Object> getData() {
        Map<String, Object> data  = new HashMap<>();
        data.put("Users", this.userService.getCountUsers());
        data.put("Messages", this.messageService.getCountMessage());
        data.put("Sessions", this.getSessionCount());
        return data;
    }

    public static StatisticService getInstance() {
        return instance;
    }
}