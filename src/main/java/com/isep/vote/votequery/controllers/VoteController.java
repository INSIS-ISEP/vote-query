package com.isep.vote.votequery.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isep.vote.votequery.model.*;
import com.isep.vote.votequery.services.*;

@Tag(name = "Vote", description = "Endpoints for managing Review")
@RestController
class VoteController {

   
   @Autowired
   private VoteQueryServiceImpl voteServiceImpl;

   //  Endpoint for get a reviews by ID
   @GetMapping("/{id}")
   public ResponseEntity<VoteQuery> getVote(@PathVariable Long id){
    VoteQuery vote = voteServiceImpl.getVote(id);
    return ResponseEntity.ok(vote);
   }

   //   Endpoint to fetch all Votes
   @GetMapping
   public ResponseEntity<Iterable<VoteQuery>> getAllVotes(){
    Iterable<VoteQuery> votes = voteServiceImpl.getAllVotes();
    return ResponseEntity.ok(votes);
   }



 
}
