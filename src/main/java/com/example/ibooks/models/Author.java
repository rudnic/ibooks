package com.example.ibooks.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
@ToString
public class Author implements Serializable {

    @Id
    private int id;

    private String fullname;
    // private Date birthday;
    private String birthday;
    private String info;

    @ManyToMany(fetch = FetchType.EAGER) // , fetch = FetchType.LAZY
    @JoinTable(
            name = "authors_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    @JsonBackReference
    private Set<Book> books;
}
