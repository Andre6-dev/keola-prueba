package com.keola.agq.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.keola.agq.entity.User}
 */
public record UserDto(UUID id, @NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName,
                      @NotEmpty String username, @Email String email,
                      @NotNull @NotEmpty @NotBlank String password) implements Serializable {
}