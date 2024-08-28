package ru.example.demo.data;

import ru.example.demo.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private static final Map<Integer, User> users = new HashMap<>();

    public static Map<Integer, User> getUsers() {
        return users;
    }

    static {
        users.put(1, new User(1, "Ivan", "Ivanov", 20));
        users.put(2, new User(2, "Ivan1", "Ivanov1", 21));
        users.put(3, new User(3, "Ivan2", "Ivanov2", 22));
        users.put(4, new User(4, "Ivan3", "Ivanov3", 23));
        users.put(5, new User(5, "Ivan4", "Ivanov4", 25));
    }
}
