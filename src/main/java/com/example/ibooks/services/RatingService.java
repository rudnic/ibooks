package com.example.ibooks.services;

import com.example.ibooks.dto.requests.AddRatingRequest;
import com.example.ibooks.models.Book;
import com.example.ibooks.models.Rating;
import com.example.ibooks.models.User;
import com.example.ibooks.repository.RatingReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    RatingReposiroty ratingReposiroty;

    @Autowired
    BookService bookService;

    public void addRating(AddRatingRequest addRatingRequest, User user, int value) {
        Book book = bookService.findById(addRatingRequest.getBook_id());
        Rating rating = new Rating(book, user, value);
        System.out.println(rating);
        ratingReposiroty.save(new Rating(book, user, value));
    }

}
