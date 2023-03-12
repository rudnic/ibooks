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
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String snippet;
    private float rating;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER) // , fetch = FetchType.LAZY
    private List<Author> authors;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
//    @OneToMany(fetch = FetchType.EAGER)
    private Set<Review> reviews;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    // @OneToMany
    private Set<Rating> ratingList;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", snippet='" + snippet + '\'' +
                ", rating=" + rating +
                '}';
    }
}