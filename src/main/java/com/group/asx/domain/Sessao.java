package com.group.asx.domain;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "sessao")
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

    public UUID getId() {
        return id;
    }

    public Investidor getInvestidor() {
        return investidor;
    }

    public void setInvestidor(Investidor investidor) {
        this.investidor = investidor;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Instant dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public boolean isRevogado() {
        return revogado;
    }

    public void setRevogado(boolean revogado) {
        this.revogado = revogado;
    }
}