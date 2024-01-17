package com.Instagram.Instagram.exception;

import com.Instagram.Instagram.payload.ErroDetailes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
@ControllerAdvice
public class GlobalExceptionerHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroDetailes>handleResourceNotFoundexception(
            ResourceNotFoundException e,
            WebRequest webRequest
    ){
        ErroDetailes erroDetailes= new ErroDetailes(
               e.getMessage(), new Date(), webRequest.getDescription(true)
        );
        return new ResponseEntity<>(erroDetailes, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
