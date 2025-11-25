package com.issue.tracker.issue.tracker.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.annotation.Resources;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = IssueException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public @ResponseBody IssueTrackerException handleException(IssueException exception) {
		return new IssueTrackerException(HttpStatus.CONFLICT.value(),exception.getMessage());
	}
}
