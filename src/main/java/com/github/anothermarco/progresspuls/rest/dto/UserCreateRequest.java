package com.github.anothermarco.progresspuls.rest.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record UserCreateRequest(@NotEmpty @Email String email,
                                @NotEmpty String displayName,
                                @NotEmpty String password,
                                @Min(1) long roleId) {
}
