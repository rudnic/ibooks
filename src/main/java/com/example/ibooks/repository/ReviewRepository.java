package com.example.ibooks.repository;

import com.example.ibooks.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
//    @Query(value = "insert into reviews values (?1, ?2, ?3)", nativeQuery = true)
//    public void addReview(
//            @Param()
//    );
}
