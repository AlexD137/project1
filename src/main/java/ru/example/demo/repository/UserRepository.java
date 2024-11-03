package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
