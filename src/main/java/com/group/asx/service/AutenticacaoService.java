package com.group.asx.service;

import com.group.asx.domain.Investidor;
import com.group.asx.exception.BusinessException;
import com.group.asx.repository.InvestidorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AutenticacaoService {

    private final InvestidorRepository investidorRepository;
    private final PasswordEncoder passwordEncoder;
    public AutenticacaoService(InvestidorRepository investidorRepository, PasswordEncoder passwordEncoder){
        this.investidorRepository = investidorRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public String autenticar(String email, String senha) {
        Investidor investidor = investidorRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("Email ou senha incorreto"));

        if (investidor.getBloqueadoAte() != null && investidor.getBloqueadoAte().isAfter(LocalDateTime.now())){
            throw new BusinessException("Conta bloqueada temporariamente devido a multiplas tentativas de acesso");
        }
        if (!(passwordEncoder.matches(senha, investidor.getSenha()))){
            falhaLogin(investidor);
            throw new BusinessException("Email ou senha incorreto");
        }

        resgatarConta(investidor);
        return "token gerado";
    }

    private void falhaLogin(Investidor investidor){
        investidor.setTentativasLogin(investidor.getTentativasLogin()+1);
        if (investidor.getTentativasLogin() > 4){
            investidor.setBloqueadoAte(LocalDateTime.now().plusMinutes(10));
            investidor.setTentativasLogin(0);
        }
        investidorRepository.save(investidor);
    }
    private void resgatarConta(Investidor investidor){
        investidor.setTentativasLogin(0);
        investidor.setBloqueadoAte(null);
        investidorRepository.save(investidor);

    }
}
