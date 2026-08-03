package com.group.asx.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "sessao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "investidor_id", nullable = false)
    private Investidor investidor;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private Instant dataExpiracao;

    @Column(nullable = false)
    private boolean revogado;

    @Column(nullable = false, updatable = false)
    private Instant dataCriacao;

    public boolean estaExpirada() {
        return Instant.now().isAfter(dataExpiracao);
    }

    public boolean estaValida() {
        return !revogado && !estaExpirada();
    }
}