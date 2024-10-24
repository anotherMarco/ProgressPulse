package com.github.anothermarco.progresspuls.service;

import com.github.anothermarco.progresspuls.rest.dto.LoginResponse;
import com.github.anothermarco.progresspuls.rest.dto.LoginUserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    public LoginResponse authenticate(LoginUserRequest input) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.email(),
                        input.password()
                )
        );
        String jwtToken = jwtService.generateToken(input.email());

        return new LoginResponse(jwtToken);
    }

}
