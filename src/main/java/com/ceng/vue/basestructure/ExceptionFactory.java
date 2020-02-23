package com.ceng.vue.basestructure;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ExceptionFactory {

    private ExceptionFactory() {
    }

    public static void throwException(String message) {
        throw new BaseException(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static void throwException(String message, HttpStatus httpStatus) {
        throw new BaseException(message, httpStatus);
    }

    public static void throwException(String message, HttpStatus httpStatus, String... params) {
        throw new BaseException(message, httpStatus, null, Arrays.asList(params));
    }
}