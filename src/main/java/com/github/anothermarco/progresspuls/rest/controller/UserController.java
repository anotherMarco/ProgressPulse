package com.github.anothermarco.progresspuls.rest.controller;

import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import com.github.anothermarco.progresspuls.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserCreatedResponse> createUser(@RequestBody UserCreateRequest request) {
        UserCreatedResponse user = userService.createUser(request);
        return ResponseEntity.ok(user);
    }
}
