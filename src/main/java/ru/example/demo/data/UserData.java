package ru.example.demo.data;

import ru.example.demo.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private final Map<Long, User> users = new HashMap<>();
    public Map<Long, User> getUsers() {
        return users;
    }

    {
        users.put(1L, new User( 1L, "Ivan",  "Ivanov",  20) );
        users.put(2L, new User( 2L, "Ivan1",  "Ivanov1",  21) );
        users.put(3L, new User( 3L, "Ivan2",  "Ivanov2",  22) );
        users.put(4L, new User( 4L, "Ivan3",  "Ivanov3",  23) );
        users.put(5L, new User( 5L, "Ivan4",  "Ivanov4",  25) );

    }
}
