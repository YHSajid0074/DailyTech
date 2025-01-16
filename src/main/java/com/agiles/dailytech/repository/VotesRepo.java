package com.agiles.dailytech.repository;

import com.agiles.dailytech.model.votes.Votes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotesRepo extends JpaRepository<Votes,Long> {

}
