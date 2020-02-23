package com.ceng.vue.basestructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class ApiResponse<T> implements Serializable {

    private T data;

    private BaseException error;

    private HttpStatus status;

    public ApiResponse() {
    }

    public static <E> ApiResponse<E> response(E data) {
        ApiResponse<E> response = new ApiResponse();
        response.data = data;
        response.status = HttpStatus.OK;

        return response;
    }

    public static ApiResponse error(BaseException baseError) {
        ApiResponse response = new ApiResponse();
        response.error = baseError;
        response.status = baseError.getStatusCode();

        return response;
    }


}