package com.group.asx.domain;

import com.group.asx.domain.enums.StatusUsuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "investidores")
@Getter
@Setter
public class Investidor extends Usuario{

    @Column(unique = true, nullable = false)
    private String nomeInvestidor;

    private String fotoPerfil;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private int qtdTemporadasDisputadas;

    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusUsuario status;

    @Column(nullable = false)
    private boolean confirmouMaioridade;

    @Column(nullable = false)
    private boolean aceitouTermos;

    @PrePersist
    protected void onCreate() {
        super.onCreateUsuario();
        this.dataCriacao = LocalDateTime.now();
        this.status = StatusUsuario.ATIVO;
        this.qtdTemporadasDisputadas = 0;
    }
}
