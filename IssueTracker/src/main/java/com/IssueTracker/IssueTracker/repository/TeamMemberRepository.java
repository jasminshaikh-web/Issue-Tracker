package com.IssueTracker.IssueTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IssueTracker.IssueTracker.Entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Long> {

}
