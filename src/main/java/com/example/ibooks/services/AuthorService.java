package com.example.ibooks.services;

import com.example.ibooks.dto.AuthorDto;
import com.example.ibooks.dto.BookDto;
import com.example.ibooks.models.Author;
import com.example.ibooks.models.Book;
import com.example.ibooks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public AuthorDto getAuthorById(int id) {
        if (authorRepository.findById(id).isEmpty())
            return null;
        return new AuthorDto(authorRepository.findById(id).get());

    }

    public List<AuthorDto> getAllAuthors() {

        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorsDto = new LinkedList<>();

        for (Author author : authors) {
            authorsDto.add(new AuthorDto(author));
        }

        return authorsDto;

    }

}
