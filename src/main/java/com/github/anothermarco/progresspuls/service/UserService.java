package com.github.anothermarco.progresspuls.service;

import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import com.github.anothermarco.progresspuls.rest.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserCreatedResponse createUser(UserCreateRequest userCreateRequest);

    UserResponse findById(long id);
}
