package com.github.anothermarco.progresspuls.rest.dto;

import com.github.anothermarco.progresspuls.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserCreateRequest(@NotEmpty @Email String email,
                                @NotEmpty String displayName,
                                @NotEmpty String password,
                                Role role) {
}
