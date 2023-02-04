package com.example.ibooks.dto.responses.author;

import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AuthorDto implements Serializable {

    private int id;
    private String fullname;
    private String birthday;
    private String info;
    private Set<AuthorsBooksListDTO> books = new HashSet<>();

}



