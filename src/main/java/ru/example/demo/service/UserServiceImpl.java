package ru.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.demo.model.User;
import ru.example.demo.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> read(int id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean put(User user, int id) {
        user.setId(id);

        userRepository.save(user);
        return true;
    }

    @Override
    public boolean patch(User user, int id) {
        Optional<User> existingUserOptional = userRepository.findById(id);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();

            if (user.getFirstName() != null) {
                existingUser.setFirstName(user.getFirstName());
            }
            if (user.getSecondName() != null) {
                existingUser.setSecondName(user.getSecondName());
            }
            if (user.getAge() != null) {
                existingUser.setAge(user.getAge());
            }

            userRepository.save(existingUser); // Сохраняем обновленного пользователя
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
