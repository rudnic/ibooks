package com.example.ibooks;

import com.example.ibooks.repository.RatingReposiroty;
import org.springframework.beans.factory.annotation.Autowired;
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
    *           Change ReviewsDto to ReviewsProfile and ReviewsBooks *
    *   4.  Add likes/dislikes
    *           add one more trigger on delete
    *           just do it in api
    *   5.  Change age to bday
    *   6.  Add photos ?
    *   7.  Add friends
    *   8.  Add messenger ?
    *
    *
    */
}
