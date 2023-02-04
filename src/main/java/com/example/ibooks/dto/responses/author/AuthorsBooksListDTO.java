package com.example.ibooks.dto.responses.author;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthorsBooksListDTO implements Serializable {
    private int id;
    private String name;
    private String snippet;
    private float rating;
}