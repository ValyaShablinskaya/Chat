package by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Message;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;

import java.util.List;
import java.util.Optional;

public interface IMessageStorage extends IEssenceStorage<Message>{
    List<Message> getByToWhom(User user);
    List<Message> getByFromWhom(User user);
    long getCount();
}
