package com.group.asx.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "tokens_recuperacao")
@Getter
@Setter
public class TokenRecuperacao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String token;

    private LocalDateTime dataExpiracao;

    private Boolean utilizado;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "investidor_id", nullable = false)
    private Investidor investidor;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
        this.utilizado = false;
    }
}
