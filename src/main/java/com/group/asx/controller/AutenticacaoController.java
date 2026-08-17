package com.group.asx.controller;

import com.group.asx.dto.LoginRequestDTO;
import com.group.asx.dto.LoginResponseDTO;
import com.group.asx.service.AutenticacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    public AutenticacaoController(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        String token = autenticacaoService.autenticar(loginRequestDTO.email(), loginRequestDTO.senha());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
