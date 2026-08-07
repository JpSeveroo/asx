package com.group.asx.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RedefinirSenhaDTO(
        @NotBlank(message = "O envio do token é obrigatório")
        String token,
        @NotBlank (message = "A senha é obrigatória")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
                message = "A senha deve conter ao menos uma letra maiúscula, uma minúscula e um número")
        String senha
) {}
