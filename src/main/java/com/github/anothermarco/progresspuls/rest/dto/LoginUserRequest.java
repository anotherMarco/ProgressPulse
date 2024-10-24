package com.github.anothermarco.progresspuls.rest.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginUserRequest(@NotEmpty String email, @NotEmpty String password) {
}
