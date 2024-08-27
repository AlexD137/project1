package ru.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.demo.dto.User;

import java.util.ArrayList;

import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;
import ru.example.demo.data.UserData;

@Service
public class UserServiceImpl implements UserService {

    private final UserData userData;
    // Переменная для генерации ID клиента
    private  volatile AtomicInteger clientIdHolder;


    @Autowired
    public UserServiceImpl(UserData userData) {
        this.userData = userData;
        this.clientIdHolder = new AtomicInteger(userData.getUsers().size()) ;
    }

    @Override
    public void create(User user) {
        final int userId = clientIdHolder.incrementAndGet();
        user.setId(userId);
        userData.getUsers().put(userId, user);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(userData.getUsers().values());
    }

    @Override
    public User read(int id) {
        return userData.getUsers().get(id);
    }

    @Override
    public boolean putUpdate(User user, int id) {
        if (userData.getUsers().containsKey(id)) {
            user.setId(id);
            userData.getUsers().put(id, user);
            return true;
        }

        return false;
    }

    @Override
    public boolean patchUpdate(User user, int id) {
        if (userData.getUsers().containsKey(id)) {
            user.setId(id);
            User newUser = userData.getUsers().get(id);
            if (user.getFirstName() != null) {
                newUser.setFirstName(user.getFirstName());
            }
            if (user.getSecondName() != null) {
                newUser.setSecondName(user.getSecondName());
            }
            if (user.getAge() != null) {
                newUser.setAge(user.getAge());
            }

            userData.getUsers().put(id, newUser);
            return true;
        }

        return false;

    }

    @Override
    public boolean delete(int id) {
        return userData.getUsers().remove(id) != null;
    }
}

