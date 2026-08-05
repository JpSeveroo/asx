package com.group.asx.dto;


import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CadastroRequestDTO(
        @NotBlank (message = "O nome do investidor é obrigatório")
        String nomeInvestidor,

        @Email (message = "Formato de e-mail inválido")
        @NotBlank (message = "O e-mail é obrigatório")
        String email,

        @NotBlank (message = "A senha é obrigatória")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
                message = "A senha deve conter ao menos uma letra maiúscula, uma minúscula e um número")
        String senha,

        @NotBlank (message = "A confirmação de senha é obrigatória")
        String confirmacaoSenha,

        @AssertTrue (message = "Você deve confirmar que é maior de idade")
        boolean confirmouMaioridade,

        @AssertTrue (message = "Você deve aceitar os termos de uso")
        boolean aceitouTermos
                                    ) {
}
