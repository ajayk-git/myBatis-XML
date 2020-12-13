package com.mybatis.Student.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ResourceAlreadyExist extends RuntimeException {
    public ResourceAlreadyExist(String message){
        super(message);
    }
}
