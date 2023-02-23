package com.example.ibooks.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reviews")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(generator = "review_sequence")
    @SequenceGenerator(name = "review_sequence", sequenceName = "REVIEW_SEQ", allocationSize = 5)
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
