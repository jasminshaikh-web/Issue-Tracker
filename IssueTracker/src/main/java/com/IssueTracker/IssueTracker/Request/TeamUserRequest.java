package com.IssueTracker.IssueTracker.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TeamUserRequest {

	private String name;
	private String email;
	private String designation;
}
