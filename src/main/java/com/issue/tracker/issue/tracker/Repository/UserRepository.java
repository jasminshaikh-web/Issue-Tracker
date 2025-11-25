package com.issue.tracker.issue.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue.tracker.issue.tracker.Entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

}
