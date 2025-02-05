package com.example.ecommerce.dto;

import com.example.ecommerce.model.Produto;

import java.util.List;

public class CompraRequestDTO {
    private String cpf;
    private List<Produto> produtos;

    public CompraRequestDTO() {
    }

    public CompraRequestDTO(String cpf, List<Produto> produtos) {
        this.cpf = cpf;
        this.produtos = produtos;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
