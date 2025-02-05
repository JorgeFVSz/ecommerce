package com.example.ecommerce.dto;

import jakarta.validation.constraints.Min;

public class ProdutoRequestDTO {
    private String nome;
    @Min(value = 1, message = "O preço deve ser maior que 0")
    private Double preco;
    @Min(value = 0, message = "A quantidade deve ser maior ou igual a 0")
    private int quantidade;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, Double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
