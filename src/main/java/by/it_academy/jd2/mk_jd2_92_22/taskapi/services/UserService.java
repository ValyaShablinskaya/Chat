package by.it_academy.jd2.mk_jd2_92_22.taskapi.services;

import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.Role;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.entity.User;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.api.IUserService;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.exception.EntityAlreadyExistException;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.services.exception.EntityNotFoundException;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.UserStorage;
import by.it_academy.jd2.mk_jd2_92_22.taskapi.storage.api.IUserStorage;

import java.time.LocalDate;
import java.util.List;

public class UserService implements IUserService {
    private static final UserService instance = new UserService();
    private final IUserStorage storage;

    private UserService() {
        this.storage = UserStorage.getInstance();
    }

    @Override
    public List<User> get() {
        return this.storage.get();
    }

   // @Override
//    public User get(int id) {
//        return this.storage.getById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
//    }

    @Override
    public User getByLogin(String login) {
        return storage.getByLogin(login).orElseThrow(() -> new EntityNotFoundException("Login not found"));
    }

    @Override
    public boolean login(String login, String password) {
        return storage.getByLogin(login)
                .map(User::getPassword)
                .filter(pass -> pass.equals(password))
                .isPresent();
    }

    @Override
    public void validate(User item) {
        if (item == null) {
            throw new IllegalStateException("You did not transfer the user");
        }
//        if (storage.getById(item.getId()).isPresent()) {
//            throw new EntityAlreadyExistException("id already exist");
//        }
        if (storage.getByLogin(item.getLogin()).isPresent()) {
            throw new EntityAlreadyExistException("login already exist");
        }
        if (item.getPassword() == null) {
            throw new IllegalArgumentException("You did not enter password");
        }
        if (item.getFullName() == null) {
            throw new IllegalArgumentException("You did not enter full name");
        }
        if (item.getBirthday() == null) {
            throw new IllegalArgumentException("You did not enter birthday");
        }
    }

    @Override
    public void add(User user) {
        this.validate(user);
        user.setDateOfRegistration(LocalDate.now());
        user.setRole(Role.USER);
        this.storage.save(user);
    }

    @Override
    public long getCountUsers() {
        return this.storage.getCount();
    }

    public static UserService getInstance() {
        return instance;
    }

}