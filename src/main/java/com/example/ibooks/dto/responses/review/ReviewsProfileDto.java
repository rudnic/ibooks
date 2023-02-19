package com.example.ibooks.dto.responses.review;

import com.example.ibooks.dto.responses.book.AllBooksDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsProfileDto implements Serializable {
    private int id;
    private AllBooksDto book;
    private String date;
    private String text;
}
