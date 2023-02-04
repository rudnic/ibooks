package com.example.ibooks.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String snippet;
    private float rating;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER) // , fetch = FetchType.LAZY
    private Set<Author> authors;

    @OneToMany(mappedBy = "book")
    private Set<Review> reviews;
}