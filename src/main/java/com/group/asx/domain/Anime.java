package com.group.asx.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.validator.constraints.UUID;

@Entity
@Table (name = "anime")
public class Anime {
    private UUID id;
    private String nome;
    private String estudio;
    private boolean emLancamento;
}
