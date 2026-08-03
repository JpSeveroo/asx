package com.group.asx.repository;

import com.group.asx.domain.Investidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InvestidorRepository extends JpaRepository<Investidor, UUID> {

    boolean existsByEmail(String email);


    boolean existsByNomeInvestidor(String nomeInvestidor);

    Optional<Investidor> findByEmail(String email);
}
