package com.sripal.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class SsnidRestApiException{
	
    @ExceptionHandler(value=NoDatafoundException.class)
	public ResponseEntity<ErrorResponse> handle_Nodatafoundexception(NoDatafoundException exception){
		
		ErrorResponse response = new ErrorResponse();
		response.setTimeStamp(new Date());
		response.setStatusCode(HttpStatus.NOT_FOUND.value());
		response.setMessage(exception.getMessage());
		response.setDeatails(exception.getLocalizedMessage());
		
		
		
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
    @ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ErrorResponse>handle_method_validation(MethodArgumentNotValidException exception) {
	ErrorResponse response = new ErrorResponse();
	response.setTimeStamp(new Date());
	response.setStatusCode(HttpStatus.NOT_FOUND.value());
	response.setMessage("validation Error");
	response.setDeatails(exception.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	 @ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorResponse> handle_ception(Exception exception){
			
			ErrorResponse response = new ErrorResponse();
			response.setTimeStamp(new Date());
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setMessage(exception.getMessage());
			response.setDeatails(response.getDeatails());
			
			return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
		}

}
