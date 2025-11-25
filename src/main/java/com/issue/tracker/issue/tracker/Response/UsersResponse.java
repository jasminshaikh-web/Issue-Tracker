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
public class UsersResponse {
	 private Long id;
	 private String name;
	 private String role;
//	 private String title;
	 
}
