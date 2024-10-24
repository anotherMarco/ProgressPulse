package com.github.anothermarco.progresspuls.rest.controller;

import com.github.anothermarco.progresspuls.rest.dto.UserCreateRequest;
import com.github.anothermarco.progresspuls.rest.dto.UserCreatedResponse;
import com.github.anothermarco.progresspuls.rest.dto.UserResponse;
import com.github.anothermarco.progresspuls.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<@Valid UserCreatedResponse> createUser(@RequestBody @Valid UserCreateRequest request) {
        UserCreatedResponse user = userService.createUser(request);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<@Valid UserResponse> findById(@PathVariable @Min(1) long id) {
        UserResponse user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
