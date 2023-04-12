package com.isep.vote.votequery.services;

import com.isep.vote.votequery.model.VoteQuery;

public interface VoteQueryService {

    Iterable<VoteQuery> getAllVotes();

    VoteQuery getVote(Long idReview);
}
