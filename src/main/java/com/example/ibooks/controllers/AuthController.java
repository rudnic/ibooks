package com.example.ibooks.controllers;

import com.example.ibooks.config.JwtUtil;
import com.example.ibooks.dto.requests.LoginRequest;
import com.example.ibooks.dto.requests.SignupRequest;
import com.example.ibooks.dto.responses.JwtResponse;
import com.example.ibooks.exception.EmailAlreadyUsedException;
import com.example.ibooks.exception.IncorrectEmailException;
import com.example.ibooks.exception.PasswordsDoesntMatchException;
import com.example.ibooks.exception.UsernameAlreadyUsedException;
import com.example.ibooks.models.User;
import com.example.ibooks.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class AuthController {

    final
    AuthenticationManager authenticationManager;

    final
    UserService userService;

    final
    PasswordEncoder passwordEncoder;

    final
    JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        com.example.ibooks.models.User user = (User) authentication.getPrincipal();
        return new ResponseEntity<>(new JwtResponse(
                jwt, user.getId(), user.getUsername(), user.getEmail()
        ), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        // signupRequest.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        // signupRequest.setConfirmPassword(passwordEncoder.encode(signupRequest.getConfirmPassword()));
//        boolean result = userService.registerUser(signupRequest);
//        if (result)
//            return new ResponseEntity<>("Register successful", HttpStatus.OK);
//
//        return new ResponseEntity<>("Something going wrong", HttpStatus.BAD_REQUEST);
        try {
            userService.registerUser(signupRequest);
        } catch (PasswordsDoesntMatchException | IncorrectEmailException | EmailAlreadyUsedException |
                 UsernameAlreadyUsedException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Register successful", HttpStatus.OK);
    }

}
