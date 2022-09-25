package by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Message;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;

import java.util.List;

public interface IMessageService extends IEssenceService<Message> {
    void add(Message message);
    List <Message> getToWhom(User user);
    List <Message> getFromWhom(User user);
    long getCountMessage();
}
