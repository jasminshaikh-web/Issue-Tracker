package com.IssueTracker.IssueTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.IssueTracker.Entity.Team;

public interface TeamRepository extends JpaRepository<Team,Long>{

}
