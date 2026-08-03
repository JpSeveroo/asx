package com.group.asx.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    private int tentativasLogin;
    private LocalDateTime bloqueadoAte;

    @PrePersist
    protected void onCreateUsuario() {
        this.tentativasLogin = 0;
        this.bloqueadoAte = null;
    }
}
