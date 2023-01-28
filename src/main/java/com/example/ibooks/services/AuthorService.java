package com.example.ibooks.services;

import com.example.ibooks.dto.responses.aurhor.AllAuthorsList;
import com.example.ibooks.dto.responses.aurhor.AuthorDto;
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

    public AuthorDto getAuthorById(int id) {
        if (authorRepository.findById(id).isEmpty())
            return null;
        Author author = authorRepository.findById(id).get();
        return null; // TODO
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
