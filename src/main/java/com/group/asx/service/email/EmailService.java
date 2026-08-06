package com.group.asx.service.email;


public interface EmailService {
    void enviarEmailRecuperacao(String destinatario, String nome, String token);
}
