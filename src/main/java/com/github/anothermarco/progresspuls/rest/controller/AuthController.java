package com.github.anothermarco.progresspuls.rest.controller;

import com.github.anothermarco.progresspuls.rest.dto.LoginResponse;
import com.github.anothermarco.progresspuls.rest.dto.LoginUserRequest;
import com.github.anothermarco.progresspuls.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserRequest loginUserRequest) {
        LoginResponse authenticate = authenticationService.authenticate(loginUserRequest);
        return ResponseEntity.ok(authenticate);
    }
}
