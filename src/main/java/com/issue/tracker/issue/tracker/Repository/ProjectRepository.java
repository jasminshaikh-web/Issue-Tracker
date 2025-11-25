package com.issue.tracker.issue.tracker.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issue.tracker.issue.tracker.Entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{

}
