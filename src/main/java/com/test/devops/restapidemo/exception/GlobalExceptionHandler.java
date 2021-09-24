package com.test.devops.restapidemo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice //@controlleradvice va a menajar/capturar todas las excepciones 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> ResourceNotFoundException(ResourceNotFoundException exc, WebRequest request){
        ErrorResponse errorDetails= new ErrorResponse(new Date(),HttpStatus.NOT_FOUND.toString(),exc.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> GlobeExceptionHandler(Exception exc, WebRequest request){
        ErrorResponse errorDetails= new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), exc.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
