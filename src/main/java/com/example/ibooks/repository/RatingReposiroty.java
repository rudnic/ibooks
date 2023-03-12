package com.example.ibooks.repository;

import com.example.ibooks.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingReposiroty extends JpaRepository<Rating, Long> {
}
