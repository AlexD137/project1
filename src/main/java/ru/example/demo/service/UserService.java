package ru.example.demo.service;

import ru.example.demo.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {


        User create(User user);

        List<User> readAll();

        Optional<User> read(int id);

        boolean put(User user, int id);

        boolean patch(User user, int id);

        boolean delete(int id);
    }

