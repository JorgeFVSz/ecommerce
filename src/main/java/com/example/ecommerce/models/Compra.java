package com.example.ecommerce.models;

import java.util.List;

public class Compra {

    private Long id;
    private String cpf;
    private List<Produto> produtos;

    public Compra() {
    }

    public Compra(Long id, String cpf, List<Produto> produtos) {
        this.id = id;
        this.cpf = cpf;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
