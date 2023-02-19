package com.example.ibooks.dto.responses.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewBookDto {
    private int id;
    private ReviewsProfileDto user;
    private String date;
    private String text;

}
