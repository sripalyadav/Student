package com.sripal.Exception;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private Date TimeStamp;
	private int statusCode;
	private String Message;
	private String deatails;


}
