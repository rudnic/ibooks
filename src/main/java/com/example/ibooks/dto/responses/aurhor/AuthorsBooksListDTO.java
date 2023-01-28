package com.example.ibooks.dto.responses.aurhor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@Setter
class AuthorsBooksListDTO implements Serializable {
    private int id;
    private String name;
    private String snippet;
    private float rating;
}