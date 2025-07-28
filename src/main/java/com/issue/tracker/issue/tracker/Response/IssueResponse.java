package com.issue.tracker.issue.tracker.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.issue.tracker.issue.tracker.Entity.Issue.Priority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IssueResponse {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String assignee;
    private String reporter;
    private Priority priority;
    private LocalDate dueDate;
    private LocalDateTime createdAt;

}

