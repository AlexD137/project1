package ru.example.demo.service;

import org.springframework.stereotype.Service;
import ru.example.demo.dto.User;
import ru.example.demo.data.UserData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceImpl implements UserService {

    private final AtomicInteger clientIdHolder = new AtomicInteger(UserData.getUsers().size());

    @Override
    public void create(User user) {
        final int userId = clientIdHolder.incrementAndGet();
        user.setId(userId);
        UserData.getUsers().put(userId, user);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(UserData.getUsers().values());
    }

    @Override
    public User read(int id) {
        return UserData.getUsers().get(id);
    }

    @Override
    public boolean put(User user, int id) {
        if (UserData.getUsers().containsKey(id)) {
            user.setId(id);
            UserData.getUsers().put(id, user);
            return true;
        }

        return false;
    }

    @Override
    public boolean patch(User user, int id) {
        if (UserData.getUsers().containsKey(id)) {
            user.setId(id);
            User newUser = UserData.getUsers().get(id);
            if (user.getFirstName() != null) {
                newUser.setFirstName(user.getFirstName());
            }
            if (user.getSecondName() != null) {
                newUser.setSecondName(user.getSecondName());
            }
            if (user.getAge() != null) {
                newUser.setAge(user.getAge());
            }

            UserData.getUsers().put(id, newUser);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        return UserData.getUsers().remove(id) != null;
    }
}

