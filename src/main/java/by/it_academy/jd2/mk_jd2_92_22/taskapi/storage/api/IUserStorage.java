package by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;

import java.util.Optional;

public interface IUserStorage extends IEssenceStorage<User> {
    Optional<User> getByLogin(String login);
    long getCount();
}
