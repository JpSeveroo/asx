package com.group.asx.service;

import com.group.asx.dto.LivroCadastroDTO;
import com.group.asx.dto.LivroResponseDTO;
import com.group.asx.repository.LivroRepository;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }


    LivroResponseDTO cadastrar(LivroCadastroDTO dto);
}
