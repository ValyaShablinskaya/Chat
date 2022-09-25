package by.it_academy.jd2.mk_jd2_92_22.taskapi.storage;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Message;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Role;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api.IMessageStorage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MessageStorage implements IMessageStorage {
    private static MessageStorage instance = new MessageStorage();
    public List<Message> data = new ArrayList<>();

    @Override
    public List<Message> get() {
        return this.data;
    }

    @Override
    public void save(Message message) {
        this.data.add(message);
    }

    @Override
    public List<Message> getByToWhom(User user) {
        List<Message> messages = get();
        return messages.stream()
                .filter(message -> Objects.equals(message.getToWhom(), user))
                .collect(Collectors.toList());
    }

    @Override
    public List<Message> getByFromWhom(User user) {
        List<Message> messages = get();
        return messages.stream()
                .filter(message -> Objects.equals(message.getFromWhom(), user))
                .collect(Collectors.toList());
    }

    private MessageStorage() {
        this.data.add(Message.builder()
                        .messageSendingDate(LocalDateTime.of(2022, Month.SEPTEMBER, 22, 23, 15, 30))
                        .fromWhom(User.builder()
                                //.id(1)
                                .login("123")
                                .password("123")
                                .fullName("Shablinskaya Valya Thigmontovna")
                                .birthday(LocalDate.of(1988, Month.APRIL, 20))
                                .dateOfRegistration(LocalDate.of(2022, Month.SEPTEMBER, 20))
                                .role(Role.ADMIN)
                                .build())
                        .toWhom(User.builder()
                                //.id(1)
                                .login("111")
                                .password("111")
                                .fullName("olya")
                                .birthday(LocalDate.of(1988, Month.APRIL, 20))
                                .dateOfRegistration(LocalDate.of(2022, Month.SEPTEMBER, 22))
                                .role(Role.USER)
                                .build())
                        .text("hhh")
                .build());
    }

    @Override
    public long getCount() {
        return this.data.size();
    }

    public static MessageStorage getInstance() {
        return instance;
    }
}
