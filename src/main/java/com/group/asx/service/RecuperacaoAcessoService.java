package com.group.asx.service;

import com.group.asx.domain.Investidor;
import com.group.asx.domain.TokenRecuperacao;
import com.group.asx.exception.BusinessException;
import com.group.asx.repository.InvestidorRepository;
import com.group.asx.repository.TokenRecuperacaoRepository;
import com.group.asx.service.email.EmailService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RecuperacaoAcessoService {

    private final InvestidorRepository investidorRepository;
    private final TokenRecuperacaoRepository tokenRecuperacaoRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    public RecuperacaoAcessoService(InvestidorRepository investidorRepository, TokenRecuperacaoRepository tokenRecuperacaoRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
        this.investidorRepository = investidorRepository;
        this.tokenRecuperacaoRepository = tokenRecuperacaoRepository;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
    }

    public void solicitarRecuperacao(String email) {
        Investidor investidor = investidorRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Email solicitado não cadastrado"));

        if ((tokenRecuperacaoRepository.countByInvestidorAndDataCriacaoAfter(investidor, LocalDateTime.now().minusHours(24))) >= 3) {
            throw new BusinessException("Limite de solicitações diárias de recuperação atingido");
        }

        List<TokenRecuperacao> tokensPendentes = tokenRecuperacaoRepository.findByInvestidorAndUtilizadoFalse(investidor);
        tokensPendentes.forEach(t -> t.setUtilizado(true));
        tokenRecuperacaoRepository.saveAll(tokensPendentes);

        TokenRecuperacao token = new TokenRecuperacao();
        token.setToken(UUID.randomUUID().toString());
        token.setInvestidor(investidor);
        token.setDataExpiracao(LocalDateTime.now().plusMinutes(20));
        tokenRecuperacaoRepository.save(token);
        emailService.enviarEmailRecuperacao(investidor.getEmail(), investidor.getNomeInvestidor(), token.getToken());

    }

    public void redefinirSenha(String tokenEnviado, String novaSenha){
        TokenRecuperacao token = tokenRecuperacaoRepository.findByToken(tokenEnviado)
                .orElseThrow(() -> new BusinessException("Token inválido ou não encontrado"));
        if(token.getUtilizado()){
            throw new BusinessException("Token inválido ou não encontrado");
        }
        if (token.getDataExpiracao().isBefore(LocalDateTime.now())){
            throw new BusinessException("Token inválido ou não encontrado");
        }
        Investidor investidor = token.getInvestidor();
        investidor.setSenha(passwordEncoder.encode(novaSenha));
        investidorRepository.save(investidor);
        token.setUtilizado(true);
        tokenRecuperacaoRepository.save(token);
    }
}

