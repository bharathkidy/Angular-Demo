package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.demo.model.Error;

@Component
@ControllerAdvice
public class ExceptionHandlerUtil {
	
	@ExceptionHandler(InvalidCredentials.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	Error invalidCredentals(InvalidCredentials ex) {
		return new Error("invalidCredentials",ex.getMessage());
	}
}
