package com.group.asx.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
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

    private String status;

    @Column(nullable = false)
    private boolean confirmouMaioridade;

    @Column(nullable = false)
    private boolean aceitouTermos;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
        this.status = "ATIVO";
        this.qtdTemporadasDisputadas = 0;
    }
}
