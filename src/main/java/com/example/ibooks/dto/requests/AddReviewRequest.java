package com.example.ibooks.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddReviewRequest {
    private String date;
    private String text;
    private int bookId;
}
