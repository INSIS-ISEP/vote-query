package com.isep.vote.votequery.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.isep.vote.votequery.model.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryRepository extends CrudRepository<Review, Long> {

    @Query("SELECT r FROM Review r WHERE r.approvalStatus='pending'")
    Optional<List<Review>> findPendingReviews();

    @Query("SELECT r FROM Review r WHERE r.approvalStatus='active'")
    Optional<List<Review>> findActiveReviews();
}
