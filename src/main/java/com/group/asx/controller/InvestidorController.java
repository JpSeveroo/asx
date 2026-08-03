package com.group.asx.controller;

import com.group.asx.dto.CadastroRequestDTO;
import com.group.asx.service.InvestidorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/investidores")
public class InvestidorController {
    private final InvestidorService investidorService;

    public InvestidorController (InvestidorService investidorService) {
        this.investidorService = investidorService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@Valid @RequestBody CadastroRequestDTO investidorCadastroDto){
        investidorService.cadastrar(investidorCadastroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cadastro efetuado com sucesso!");
    }
}
