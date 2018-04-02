package com.example.accountservice.entity;

import java.util.Date;

public class ExceptionResponse {

	
	public ExceptionResponse(String message,String detail,Date date) {
		this.message=message;
		this.detail=detail;
		this.date=date;
	
	}
	
	public String message;
	public String detail;
	public Date date;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
}
