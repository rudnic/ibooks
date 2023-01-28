package com.example.ibooks.services;

import com.example.ibooks.dto.responses.aurhor.AllAuthorsList;
import com.example.ibooks.dto.responses.aurhor.AuthorDto;
import com.example.ibooks.dto.responses.aurhor.ConverterToAuthorDto;
import com.example.ibooks.models.Author;
import com.example.ibooks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ConverterToAuthorDto converterToAuthorDto;

    public AuthorDto getAuthorById(int id) { // its cannot convert nested classes
        if (authorRepository.findById(id).isEmpty())
            return null;
        return converterToAuthorDto.mapperToAuthorDto(authorRepository.findById(id).get());
    }

    public List<AllAuthorsList> getAllAuthors() {

        List<Author> authors = authorRepository.findAll();
        List<AllAuthorsList> authorsList = new ArrayList<>();

        for (Author author : authors) {
            authorsList.add(new AllAuthorsList(
                    author.getId(),
                    author.getFullname(),
                    author.getBirthday(),
                    author.getInfo()
            ));
        }

        return authorsList;

    }

}
