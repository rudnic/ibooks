package com.example.ibooks.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    private int id;
    private Date date;
    private String text;
}
