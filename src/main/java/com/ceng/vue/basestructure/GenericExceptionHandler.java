package com.ceng.vue.basestructure;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GenericExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse> handleChallengeExceptionHandler(BaseException ex) {
        BaseException baseException = new BaseException(ex.getMessage(), ex.getStatusCode(), ex.getDetail(), ex.getParams());
        ApiResponse apiResponse = ApiResponse.error(baseException);

        return new ResponseEntity(apiResponse, ex.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleChallengeExceptionHandler(Exception ex) {
        BaseException baseException = new BaseException(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        ApiResponse apiResponse = ApiResponse.error(baseException);

        return new ResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}