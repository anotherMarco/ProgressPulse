package com.github.anothermarco.progresspuls.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends NoSuchElementException {
    public RoleNotFoundException(Long id) {
        super("Role with id: %s not found".formatted(id));
    }
}
