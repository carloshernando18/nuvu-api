package com.nuvu.api.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorDetail {
	

	private LocalDateTime date;

	private String code;

	private String message;
	
	private List<String> details;
	
	public ErrorDetail() {
	}

	public ErrorDetail(LocalDateTime date, String code, String message) {
		this.date = date;
		this.code = code;
		this.message = message;
	}

	public ErrorDetail(LocalDateTime date, String code, String message, List<String> details) {
		super();
		this.date = date;
		this.code = code;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		if (this.details == null) {
			this.details = new ArrayList<String>();
		}
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
	 
	
	

}
