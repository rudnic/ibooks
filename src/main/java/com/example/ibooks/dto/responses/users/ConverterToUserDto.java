package com.example.ibooks.dto.responses.users;

import com.example.ibooks.dto.responses.book.AllBooksDto;
import com.example.ibooks.dto.responses.book.ConverterToBookListDto;
import com.example.ibooks.dto.responses.rating.RatingsProfileDto;
import com.example.ibooks.dto.responses.review.ReviewsProfileDto;
import com.example.ibooks.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// TODO
@Component
public class ConverterToUserDto {

    @Autowired
    ConverterToBookListDto converter;
    public UserDto mapperToUserDto(User user) {

    List<ReviewsProfileDto > reviews = new ArrayList<>();
    Set<RatingsProfileDto> ratingList = new HashSet<>();

    user.getReviews().forEach(review -> {
        reviews.add(new ReviewsProfileDto(review.getId(), converter.mapperToBookListDto(review.getBook()),
                review.getDate(), review.getText()));
        });

    user.getRatings().forEach(rating -> {
        ratingList.add(new RatingsProfileDto(
                converter.mapperToBookListDto(rating.getBook()),
                rating.getValue()
        ));
    });

    return new UserDto(user.getId(), user.getUsername(), user.getFirstname(), user.getLastname(),
            user.getEmail(), user.getAge(), reviews, ratingList);

    }

//        UserDto.builder()
//                .id(user.getId())
//                .username(user.getUsername())
//                .firstname(user.getFirstname())
//                .lastname(user.getLastname())
//                .email(user.getEmail())
//                .age(user.getAge())
//                .reviews(user.)
//    }
}
