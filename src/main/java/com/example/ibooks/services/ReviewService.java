package com.example.ibooks.services;

import com.example.ibooks.dto.requests.AddReviewRequest;
import com.example.ibooks.models.Review;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.BookRepository;
import com.example.ibooks.repository.ReviewRepository;
import com.example.ibooks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    public boolean save(AddReviewRequest addReviewRequest, User user) {
        try {
            reviewRepository.save(Review.builder()
                    .date(addReviewRequest.getDate())
                    .text(addReviewRequest.getText())
                    .book(bookRepository.findById(addReviewRequest.getBookId()).get())
                    .user(userRepository.findById(user.getId()).get())
                    .build());
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

//addReviewRequest.getDate(), addReviewRequest.getText(),
//        userRepository.findById(addReviewRequest.getUserId()).get(),
//        bookRepository.findById(addReviewRequest.getBookId()).get()