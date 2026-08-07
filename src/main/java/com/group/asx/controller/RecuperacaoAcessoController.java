package com.group.asx.controller;

import com.group.asx.dto.RedefinirSenhaDTO;
import com.group.asx.dto.SolicitacaoRecuperacaoDTO;
import com.group.asx.service.RecuperacaoAcessoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recuperacao-acesso")
public class RecuperacaoAcessoController {
    private final RecuperacaoAcessoService recuperacaoAcessoService;
    public RecuperacaoAcessoController(RecuperacaoAcessoService recuperacaoAcessoService){
        this.recuperacaoAcessoService = recuperacaoAcessoService;
    }

    @PostMapping("/solicitar")
    public ResponseEntity<Void> solicitarRecuperacao(@Valid @RequestBody SolicitacaoRecuperacaoDTO solicitacaoRecuperacaoDTO){
        recuperacaoAcessoService.solicitarRecuperacao(solicitacaoRecuperacaoDTO.email());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/redefinir")
    public ResponseEntity<Void> redefinirSenha(@Valid @RequestBody RedefinirSenhaDTO redefinirSenhaDTO){
        recuperacaoAcessoService.redefinirSenha(redefinirSenhaDTO.token(), redefinirSenhaDTO.senha());
        return ResponseEntity.ok().build();
    }
}
