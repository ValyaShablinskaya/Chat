package by.it_academy.jd2.mk_jd2_92_22.taskapi;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.UserService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.UserStorage;

import java.time.LocalDate;
import java.time.Month;

public class main {
    public static void main(String[] args) {

        UserService.getInstance().add(User.builder()
                .login("jkk")
                .birthday(LocalDate.of(1988, Month.SEPTEMBER, 12))
                .password("123")
                .fullName("ghjjk")
                .build());
        User jkk = UserService.getInstance().getByLogin("jkk");
        boolean users = UserService.getInstance().login("123", "123");

        System.out.println(users);

    }
}
