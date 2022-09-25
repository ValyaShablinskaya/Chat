package by.it_academy.jd2.mk_jd2_92_22.taskapi.storage;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Role;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api.IUserStorage;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UserStorage implements IUserStorage {
    private static UserStorage instance = new UserStorage();
    public List<User> data = new ArrayList<>();

    @Override
    public List<User> get() {
        return this.data;
    }

   //@Override
//    public Optional<User> getById(int id) {
//        return this.data.stream()
//                .filter(a -> a.getId() == id)
//                .findFirst();
//    }

    @Override
    public void save(User user) {
        this.data.add(user);
    }

    @Override
    public Optional<User> getByLogin(String login) {
        return this.data.stream()
                .filter(a -> Objects.equals(a.getLogin(), login))
                .findFirst();
    }

    private UserStorage() {
        this.data.add(User.builder()
               //.id(1)
                .login("123")
                .password("123")
                .fullName("Shablinskaya Valya Thigmontovna")
                .birthday(LocalDate.of(1988, Month.APRIL, 20))
                .dateOfRegistration(LocalDate.of(2022, Month.SEPTEMBER, 20))
                .role(Role.ADMIN)
                .build());

        this.data.add(User.builder()
                //.id(1)
                .login("111")
                .password("111")
                .fullName("olya")
                .birthday(LocalDate.of(1988, Month.APRIL, 20))
                .dateOfRegistration(LocalDate.of(2022, Month.SEPTEMBER, 22))
                .role(Role.USER)
                .build());
    }
    @Override
    public long getCount() {
        return this.data.size();
    }

    public static UserStorage getInstance() {
        return instance;
    }
}
