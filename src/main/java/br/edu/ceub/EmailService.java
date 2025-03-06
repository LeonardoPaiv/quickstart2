package br.edu.ceub;
// Serviço de email que notifica o cliente.
// Retorna true se o envio do email foi simulado com sucesso.

public class EmailService {
    public boolean sendEmail(String to, String message) {
        System.out.println("Enviando email para " + to + ": " + message);
        return false;
    }
}
