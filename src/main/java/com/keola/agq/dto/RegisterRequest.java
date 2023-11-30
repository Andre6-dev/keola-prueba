package com.keola.agq.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.keola.agq.entity.User}
 */
public record RegisterRequest(@NotBlank String firstName,
                              @NotBlank String lastName,
                              @NotBlank @Size(min = 3, max = 20) String username,
                              @NotBlank @Email String email,
                              @NotBlank @Size(min = 6, max = 40) String password,
                              Set<String> roles
) implements Serializable {
}