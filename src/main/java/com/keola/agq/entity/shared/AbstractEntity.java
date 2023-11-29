package com.keola.agq.entity.shared;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

/**
 * andre on 29/11/2023
 */
@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "creado_en", updatable = false)
    private Instant createdAt = Instant.now();

    @Column(name = "modificado_en")
    private Instant lastModifiedAt;
}
