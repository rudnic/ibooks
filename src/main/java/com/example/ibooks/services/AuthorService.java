package com.example.ibooks.services;

import com.example.ibooks.dto.responses.author.AllAuthorsList;
import com.example.ibooks.dto.responses.author.AuthorDto;
import com.example.ibooks.dto.responses.author.ConverterToAuthorDto;
import com.example.ibooks.models.Author;
import com.example.ibooks.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ConverterToAuthorDto converterToAuthorDto;

    public AuthorDto getAuthorById(int id) {
//        if (authorRepository.findById(id).isEmpty())
//            return null;
        List<Author> authors = authorRepository.findAll(); // ЭТО НЕ УДАЛЯТЬ
//        Author author = authors.get(0);
//        Author author = authorRepository.findById(id).get();
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
