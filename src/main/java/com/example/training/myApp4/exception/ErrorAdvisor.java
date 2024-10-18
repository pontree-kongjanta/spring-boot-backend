package com.example.training.myApp4.exception;

import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorAdvisor {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleException(BaseException e){
            ErrorResponse response = new ErrorResponse();
            response.setStatus(HttpStatus.EXPECTATION_FAILED.value());
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
    }

     @Data
    public static class ErrorResponse{
        private LocalDateTime timestamp = LocalDateTime.now();
        private int status;
        private String errorMessage;
    }
}
