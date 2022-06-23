package com.blog.ram.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.ram.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String messageString=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(messageString,false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handelMethodArgsNotVAlidException(MethodArgumentNotValidException ex){
		Map<String, String> respMap=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
		String fieldNameString=	((FieldError)error).getField();
		String message=error.getDefaultMessage();
		respMap.put(fieldNameString, message);
		});
		
		return new ResponseEntity<Map<String,String>>(respMap,HttpStatus.BAD_REQUEST);
	}
}
