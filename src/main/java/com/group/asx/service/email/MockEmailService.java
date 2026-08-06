package com.group.asx.service.email;


import org.springframework.stereotype.Service;

@Service
public class MockEmailService implements EmailService{

    @Override
    public void enviarEmailRecuperacao(String destinatario, String nome, String token){
        System.out.println("===Simulação do envio de e-mail de recuperação===");
        System.out.println("Destinatário: " + destinatario);
        System.out.println("Nome:" + nome);
        System.out.println("Token de recuperação:" + token);
    }
}
