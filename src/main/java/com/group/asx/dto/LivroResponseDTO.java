package com.group.asx.dto;

import org.hibernate.validator.constraints.UUID;

public record LivroResponseDTO(
        UUID id,
        String titulo,
        String autor,
        boolean disponivel
        ) {
}
