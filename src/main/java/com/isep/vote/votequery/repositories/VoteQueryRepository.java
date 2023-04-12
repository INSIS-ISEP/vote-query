package com.isep.vote.votequery.repositories;

import org.springframework.data.repository.CrudRepository;
import com.isep.vote.votequery.model.VoteQuery;

import java.util.List;
import java.util.Optional;

public interface VoteQueryRepository extends CrudRepository<VoteQuery, Long> {

    Optional<VoteQuery> findById(Long voteId);

    // @Query("SELECT r FROM Review r WHERE r.vote=:vote ORDER BY r.publishingDate DESC")
    Optional<List<VoteQuery>> findByVoteId(VoteQuery vote);
}
