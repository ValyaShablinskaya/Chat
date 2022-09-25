package by.it_academy.jd2.mk_jd2_92_22.taskapi.services;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Message;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IMessageService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.exception.EntityNotFoundException;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.MessageStorage;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api.IMessageStorage;

import java.time.LocalDateTime;
import java.util.List;

public class MessageService implements IMessageService {
    private static final MessageService instance = new MessageService();
    private final IMessageStorage storage;

    private MessageService() {
        this.storage = MessageStorage.getInstance();
    }

    @Override
    public List<Message> get() {
        return this.storage.get();
    }

    @Override
    public void add(Message message) {
        this.validate(message);
        message.setMessageSendingDate(LocalDateTime.now());
        this.storage.save(message);
    }

    @Override
    public List<Message> getFromWhom(User user) {
        return storage.getByToWhom(user);
    }

    @Override
    public List<Message> getToWhom(User user) {
        return storage.getByToWhom(user);
    }

    @Override
    public void validate(Message item) {
        if (item.getToWhom() == null) {
            throw new IllegalArgumentException("The field [whom] is empty");
        }
        if (item.getText() == null) {
            throw new IllegalArgumentException("The field [text] is empty");
        }
    }

    @Override
    public long getCountMessage() {
        return this.storage.getCount();
    }

    public static MessageService getInstance() {
        return instance;
    }
}
