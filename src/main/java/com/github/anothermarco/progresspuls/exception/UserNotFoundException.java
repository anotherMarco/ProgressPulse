package com.github.anothermarco.progresspuls.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends NoSuchElementException {

    public UserNotFoundException(long id) {
        super("User with id %s not found".formatted(id));
    }
}
