package com.isep.vote.votequery.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.isep.vote.votequery.model.*;
import com.isep.vote.votequery.repositories.ReviewQueryRepository;
import com.isep.vote.votequery.repositories.VoteQueryRepository;

@Service
public class VoteQueryServiceImpl implements VoteQueryService {

    @Autowired
    ReviewQueryRepository repository;

    @Autowired
    VoteQueryRepository voteRepository;

    public VoteQuery getVote(Long id){
        return voteRepository.findById(id).orElse(null);
    }

    @Override
    public Iterable<VoteQuery> getAllVotes(){
        return voteRepository.findAll();
    }
}