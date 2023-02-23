package com.example.ibooks.controllers;

import com.example.ibooks.dto.requests.AddReviewRequest;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.UserRepository;
import com.example.ibooks.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/review/add")
    public ResponseEntity<?> addReviews(@RequestBody AddReviewRequest addReviewRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal());
        return new ResponseEntity<>(reviewService.save(addReviewRequest, (User) authentication.getPrincipal()), HttpStatus.OK);
    }
}
