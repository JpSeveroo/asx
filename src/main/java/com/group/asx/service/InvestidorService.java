package com.group.asx.service;

import com.group.asx.domain.Investidor;
import com.group.asx.dto.InvestidorCadastroDto;
import com.group.asx.exception.BusinessException;
import com.group.asx.repository.InvestidorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InvestidorService {
    private final InvestidorRepository investidorRepository;
    private final PasswordEncoder passwordEncoder;

    public InvestidorService(InvestidorRepository investidorRepository, PasswordEncoder passwordEncoder){
        this.investidorRepository = investidorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void cadastrar(InvestidorCadastroDto cadastroDto){
        if (!(cadastroDto.senha().equals(cadastroDto.confirmacaoSenha()))){
            throw new BusinessException("Senha diferente da confirmação de senha");
        }
        if (investidorRepository.existsByEmail(cadastroDto.email())){
            throw new BusinessException("Esse email já está cadastrado");
        }
        if (investidorRepository.existsByNomeInvestidor(cadastroDto.nomeInvestidor())){
            throw new BusinessException("Esse nome já está sendo utilizado");
        }
        Investidor novoInvestidor = new Investidor();
        novoInvestidor.setNomeInvestidor(cadastroDto.nomeInvestidor());
        novoInvestidor.setEmail(cadastroDto.email());
        novoInvestidor.setAceitouTermos(cadastroDto.aceitouTermos());
        novoInvestidor.setConfirmouMaioridade(cadastroDto.confirmouMaioridade());
        novoInvestidor.setSenha(passwordEncoder.encode(cadastroDto.senha()));

        investidorRepository.save(novoInvestidor);

    }
}
