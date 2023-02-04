package com.example.ibooks.dto.responses.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class AllBooksDtoAuthorList {
    private int id;
    private String fullname;
}
