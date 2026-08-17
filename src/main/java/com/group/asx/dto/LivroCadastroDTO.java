package com.group.asx.dto;

import jakarta.validation.constraints.NotBlank;

public record LivroCadastroDTO(
        @NotBlank String titulo,
        @NotBlank String autor,
        @NotBlank Integer anoPublicacao
) {
}
