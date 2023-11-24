package com.rex.demo.advice;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rex.demo.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 異常統一處理類
 *
 * @author rex
 */
@RestControllerAdvice
public class ExceptionAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultErrorHandler(Exception e) {
        logger.error(e.toString());
        // 可以根據 exception 的 type 來做不同處理
        if (e instanceof IllegalArgumentException) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(e.getMessage());
        }
        if(e instanceof HttpMessageNotReadableException){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body("Required request body is missing");
        } if(e instanceof MethodArgumentNotValidException){
            Object[] args = new Object[]{e.getMessage()};
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(args);
        }
        else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
