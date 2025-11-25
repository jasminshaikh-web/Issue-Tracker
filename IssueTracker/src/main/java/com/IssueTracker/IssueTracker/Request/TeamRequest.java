package com.IssueTracker.IssueTracker.Request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamRequest {

	private String teamName;
	private List<Long> teamUsers;
}
