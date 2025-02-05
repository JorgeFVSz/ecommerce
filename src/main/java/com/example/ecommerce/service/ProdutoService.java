package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProdutoRequestDTO;
import com.example.ecommerce.dto.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoService {
    ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO);
    List<ProdutoResponseDTO> listarTodososProdutos();
    void deletarProduto(Long id);
}
