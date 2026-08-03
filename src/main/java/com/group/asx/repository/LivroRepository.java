package com.group.asx.repository;

import com.group.asx.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, UUID> {
    Optional<Livro> findByTitulo(String titulo);
}
