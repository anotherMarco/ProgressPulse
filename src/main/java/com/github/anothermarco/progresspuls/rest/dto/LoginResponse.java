package com.github.anothermarco.progresspuls.rest.dto;

import jakarta.validation.constraints.NotEmpty;

public record LoginResponse(@NotEmpty String token) {
}
