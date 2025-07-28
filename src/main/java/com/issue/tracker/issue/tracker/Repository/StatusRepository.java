package com.issue.tracker.issue.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue.tracker.issue.tracker.Entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long>{

}
