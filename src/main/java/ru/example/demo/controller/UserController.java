package ru.example.demo.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.converter.UserConverter;
import ru.example.demo.dto.UserDto;
import ru.example.demo.service.UserService;

import java.util.List;


@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserConverter userConverter;

    public UserController(UserService userService, UserConverter userConverter) {
        this.userService = userService;
        this.userConverter = userConverter;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDto userDto) {
        userService.create(userConverter.toModel(userDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> readAll() {
        final List<UserDto> users = userService.readAll().stream().map(userConverter::toDto).toList();

        return !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> read(@PathVariable(name = "id") int id) {
        return userService.read(id)
                .map(user -> new ResponseEntity<>(userConverter.toDto(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> put(@PathVariable(name = "id") int id, @RequestBody UserDto userDto) {
        final boolean updated = userService.put(userConverter.toModel(userDto), id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> patch(@PathVariable(name = "id") int id, @RequestBody UserDto userDto) {
        final boolean updated = userService.patch(userConverter.toModel(userDto), id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = userService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
