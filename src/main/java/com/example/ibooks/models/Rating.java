package com.example.ibooks.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_ratings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(generator = "rating_sequence")
    @SequenceGenerator(name = "rating", sequenceName = "RATING_SEQ", allocationSize = 5)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private int value;
}
