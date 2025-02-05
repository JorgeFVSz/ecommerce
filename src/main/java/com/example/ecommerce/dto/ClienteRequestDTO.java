package com.example.ecommerce.dto;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteRequestDTO {

    private String nome;
    @CPF(message = "CPF inválido")
    private String cpf;
    @Email(message = "E-mail inválido")
    private String email;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
