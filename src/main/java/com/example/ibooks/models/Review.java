package com.example.ibooks.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String date;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
