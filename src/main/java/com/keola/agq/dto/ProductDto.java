package com.keola.agq.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.keola.agq.entity.Product}
 */
public record ProductDto(UUID id, @NotNull @NotEmpty String name, @NotNull Double price,
                         @NotNull Double stock) implements Serializable {
}