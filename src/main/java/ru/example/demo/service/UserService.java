package ru.example.demo.service;

import ru.example.demo.dto.User;

import java.util.List;

public interface UserService {


        void create(User user);

        List<User> readAll();

        User read(int id);

        boolean putUpdate(User user, int id);

        boolean patchUpdate(User user, int id);

        boolean delete(int id);
    }

