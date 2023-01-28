package com.example.ibooks.controllers;

import com.example.ibooks.dto.responses.UserListDto;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.UserRepository;
import com.example.ibooks.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserListDto> resUsers = new ArrayList<>();

        for (User user : users) {
            resUsers.add(
                    UserListDto.builder()
                            .id(user.getId())
                            .firstname(user.getFirstname())
                            .lastname(user.getLastname())
                            .email(user.getEmail())
                            .age(user.getAge())
                            .build()
            );
        }

        return new ResponseEntity<>(resUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        User user = userService.getUserByID(id);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);
        return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
    }

}
