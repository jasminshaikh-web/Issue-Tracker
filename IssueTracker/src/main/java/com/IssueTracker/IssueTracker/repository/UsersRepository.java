package com.IssueTracker.IssueTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IssueTracker.IssueTracker.Entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

}
