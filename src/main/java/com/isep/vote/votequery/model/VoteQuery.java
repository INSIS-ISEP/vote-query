package com.isep.vote.votequery.model;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class VoteQuery {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idVote;

    @Column(name = "vote")
    private String vote;
    
    @Column(name = "userID")
    private Long userID;

    @ElementCollection
    @Column(nullable = true)
    private List<VoteQuery> upVote;

    @ElementCollection
    @Column(nullable = true)
    private List<VoteQuery> downVote;

    @Column(nullable = false)
    private String approvalStatus;


    protected VoteQuery() {

    }

    public VoteQuery(final Long idVote, final String vote, final Long userID) {
        this.idVote = Objects.requireNonNull(idVote);
        setVote(vote);
        setUserID(userID);
    }

    public VoteQuery(final Long idVote, final String vote, final Long userID, final List<VoteQuery> upVote, final List<VoteQuery> downVote) {
        this(idVote, vote, userID);
        setUpVote(upVote);
        setDownVote(downVote);
        

    }

    public VoteQuery(String vote, Long userID) {
        setVote(vote);
        setUserID(userID);
        setApprovalStatus("pending");
        this.upVote = new ArrayList<>();
        this.downVote = new ArrayList<>();
    }


    public Long getIdVote() {
        return idVote;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteQuery vote1 = (VoteQuery) o;
        return vote.equals(vote1.vote) && userID.equals(vote1.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vote, userID);
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public Boolean setApprovalStatus(String approvalStatus) {

        if( approvalStatus.equalsIgnoreCase("pending") ||
            approvalStatus.equalsIgnoreCase("approved") ||
            approvalStatus.equalsIgnoreCase("rejected")) {
            
            this.approvalStatus = approvalStatus;
            return true;
        }
        return false;
    }
    
    public List<VoteQuery> getUpVote() {
        return upVote;
    }

    public void setUpVote(List<VoteQuery> upVote) {
        this.upVote = upVote;
    }

    public List<VoteQuery> getDownVote() {
        return downVote;
    }

    public void setDownVote(List<VoteQuery> downVote) {
        this.downVote = downVote;
    }

    public boolean addUpVote(VoteQuery upVote) {

        if( !this.approvalStatus.equals("approved"))
            return false;

        if(!this.upVote.contains(upVote)){
            this.upVote.add(upVote);
            return true;
        }
        return false;
    }

    public boolean addDownVote(VoteQuery downVote) {

        if( !this.approvalStatus.equals( "approved") )
            return false;

        if(!this.downVote.contains(downVote)){
            this.downVote.add(downVote);
            return true;
        }
        return false;
    }

}
