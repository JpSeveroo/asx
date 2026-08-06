package com.group.asx.repository;

import com.group.asx.domain.Investidor;
import com.group.asx.domain.TokenRecuperacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRecuperacaoRepository extends JpaRepository<TokenRecuperacao, UUID> {

    Optional<TokenRecuperacao> findByToken(String token);

    long countByInvestidorAndDataCriacaoAfter(Investidor investidor, LocalDateTime data);

    List<TokenRecuperacao> findByInvestidorAndUtilizadoFalse(Investidor investidor);
}
