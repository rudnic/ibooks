package com.example.ibooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IbooksApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbooksApplication.class, args);
    }

    /*
    * TODO:
    *   1.  Auth *
    *   2.  Register *
    *   3.  Add reviews (and rating)
    *           Change ReviewsDto to ReviewsProfile and ReviewsBooks 
    *   4.  Add likes/dislikes
    *   5.  Change age to bday
    *   6.  Add photos
    *
    */
}
