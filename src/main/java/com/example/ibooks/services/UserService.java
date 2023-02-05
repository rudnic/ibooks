package com.example.ibooks.services;

import com.example.ibooks.dto.requests.SignupRequest;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

/*    @Autowired
    private PasswordEncoder passwordEncoder;*/

/*    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }*/

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByID(int id) {
        return userRepository.findById(id).orElse(null);
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

    public boolean registerUser(SignupRequest signupRequest) {
        if (!signupRequest.getConfirmPassword().equals(signupRequest.getPassword()))
            return false;

        // add check for email and add throw exceptions
        if (userRepository.findByUsername(signupRequest.getUsername()).isPresent()) {
            return false;
        }

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
