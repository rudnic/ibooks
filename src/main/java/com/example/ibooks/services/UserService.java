package com.example.ibooks.services;

import com.example.ibooks.dto.requests.SignupRequest;
import com.example.ibooks.dto.responses.users.ConverterToUserDto;
import com.example.ibooks.dto.responses.users.UserDto;
import com.example.ibooks.exception.EmailAlreadyUsedException;
import com.example.ibooks.exception.IncorrectEmailException;
import com.example.ibooks.exception.PasswordsDoesntMatchException;
import com.example.ibooks.exception.UsernameAlreadyUsedException;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private final ConverterToUserDto converter;

    private final UserRepository userRepository;

    public UserService(ConverterToUserDto converter, UserRepository userRepository) {
        this.converter = converter;
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserDto getUserByID(int id) {
        userRepository.findAll();
        if (userRepository.findById(id).isEmpty())
            return null;

        User user = userRepository.findById(id).get();
        return converter.mapperToUserDto(user);

    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if (user == null)
            return null;

        return User.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .age(user.getAge())
                .build();
    }

    public boolean registerUser(SignupRequest signupRequest) throws PasswordsDoesntMatchException, EmailAlreadyUsedException, UsernameAlreadyUsedException, IncorrectEmailException {
        if (!signupRequest.getConfirmPassword().equals(signupRequest.getPassword()))
            throw new PasswordsDoesntMatchException("Passwords doesn't match");
            // return false;

        // TODO: add check for email and add throw exceptions
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            throw new UsernameAlreadyUsedException("Username already used");
        }

        if (userRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException("Email already used");
        }

        if (!Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
                .matcher(signupRequest.getEmail())
                .matches())
            throw new IncorrectEmailException("Incorrect email");
        try {
            signupRequest.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
            userRepository.save(User.builder()
                    .username(signupRequest.getUsername())
                    .firstname(signupRequest.getFirstname())
                    .lastname(signupRequest.getLastname())
                    .email(signupRequest.getEmail())
                    // .password(passwordEncoder.encode(signupRequest.getPassword()))
                    .password(signupRequest.getPassword())
                    .age(signupRequest.getAge())
                    .build());
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
