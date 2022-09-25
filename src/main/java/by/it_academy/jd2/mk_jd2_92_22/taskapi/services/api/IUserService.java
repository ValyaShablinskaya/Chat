package by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;

public interface IUserService extends IEssenceService<User> {
    void add(User user);
    User getByLogin(String login);
    boolean login(String login, String password);
    long getCountUsers();
}
