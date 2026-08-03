package com.group.asx.repository;

import com.group.asx.domain.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SessaoRepository extends JpaRepository<Sessao,UUID> {
    Optional<Sessao> findByToken(String token);
    List<Sessao> findAllByInvestidorId(UUID investidorId);
}
