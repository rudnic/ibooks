package com.example.ibooks.dto.responses.book;

import com.example.ibooks.dto.responses.author.AuthorDto;
import com.example.ibooks.models.Author;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllBooksDto implements Serializable {
    private int id;
    private String name;
    private float rating;
    private List<AllBooksDtoAuthorList> authors = new ArrayList<>();


}
