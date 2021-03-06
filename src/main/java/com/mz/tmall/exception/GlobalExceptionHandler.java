package com.mz.tmall.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        e.printStackTrace();
        Class constraintViolationException = Class.forName("org.hibernate.exception.ConstraintViolationException");
        if(null!=e.getCause() && constraintViolationException == e.getCause().getClass()){
            return "A constraint has been violated. (Check if there's a foreign key constraint)";
        }
        return e.getMessage();
    }
}
