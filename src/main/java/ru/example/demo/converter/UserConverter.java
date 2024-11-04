package ru.example.demo.converter;

import org.springframework.stereotype.Component;
import ru.example.demo.model.User;
import ru.example.demo.dto.UserDto;

@Component
public class UserConverter implements Converter<UserDto, User> {

    @Override
    public UserDto toDto(User user) {
        return UserDto.builder()
                .secondName(user.getSecondName())
                .firstName(user.getFirstName())
                .age(user.getAge()).build();
    }

    @Override
    public User toModel(UserDto userDto) {
        return ru.example.demo.model.User.builder()
                .firstName(userDto.getFirstName())
                .secondName(userDto.getSecondName())
                .age(userDto.getAge())
                .build();
    }
}
