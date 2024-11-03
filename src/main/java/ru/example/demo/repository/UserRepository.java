package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
