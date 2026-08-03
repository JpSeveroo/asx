package com.group.asx.dto;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;

public record CadastroRequestDTO(
        @NotBlank String nomeInvestidor,
        @NotBlank String email,
        @NotBlank String senha,
        @NotBlank String confirmacaoSenha,
        @AssertTrue boolean confirmouMaioridade,
        @AssertTrue boolean aceitouTermos
                                    ) {
}
