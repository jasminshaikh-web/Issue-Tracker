package com.issue.tracker.issue.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue.tracker.issue.tracker.Entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long>{

}
