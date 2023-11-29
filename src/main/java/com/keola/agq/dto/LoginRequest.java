package com.keola.agq.dto;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

/**
 * DTO for {@link com.keola.agq.entity.User}
 */
public record LoginRequest(@NotBlank String username, @NotBlank String password) implements Serializable {
}