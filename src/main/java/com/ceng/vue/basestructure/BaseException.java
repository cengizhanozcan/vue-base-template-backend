package com.ceng.vue.basestructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class BaseException extends RuntimeException {

    private HttpStatus statusCode;
    private Date timestamp;
    private String detail;
    private List<String> params;

    public BaseException(String message) {
        super(message);
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        this.timestamp = new Date();
    }

    public BaseException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
        this.timestamp = new Date();
    }

    public BaseException(String message, HttpStatus statusCode, String detail) {
        super(message);
        this.statusCode = statusCode;
        this.detail = detail;
        this.timestamp = new Date();
    }

    public BaseException(String message, HttpStatus statusCode, String detail, List<String> params) {
        super(message);
        this.statusCode = statusCode;
        this.detail = detail;
        this.timestamp = new Date();
        this.params = params;
    }
}