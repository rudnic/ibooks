package com.example.ibooks.controllers;

import com.example.ibooks.models.Rating;
import com.example.ibooks.repository.RatingReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Test {

    @Autowired
    private RatingReposiroty ratingReposiroty;

    @GetMapping("/test-ratings")
    public ResponseEntity<?> test() {
        List<Rating> ratingList = ratingReposiroty.findAll();
        return new ResponseEntity<>(ratingList, HttpStatus.ACCEPTED);
    }
}
