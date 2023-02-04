package com.example.ibooks.dto.responses.book;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BooksAuthorsListDTO implements Serializable {
    private int id;
    private String fullname;
}
