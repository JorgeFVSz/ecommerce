package com.example.ecommerce.service;

import com.example.ecommerce.dto.ProdutoRequestDTO;
import com.example.ecommerce.dto.ProdutoResponseDTO;
import com.example.ecommerce.exception.DuplicateEntryException;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.Produto;
import com.example.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO produtoRequestDTO) {
        if (produtoRepository.existsByNome(produtoRequestDTO.getNome())) {
            throw new DuplicateEntryException("Produto com nome " + produtoRequestDTO.getNome() + " já está cadastrado");
        }

        Produto produto = new Produto(produtoRequestDTO.getNome(), produtoRequestDTO.getPreco(), produtoRequestDTO.getQuantidade());
        Produto produtoSalvo = produtoRepository.save(produto);
        return new ProdutoResponseDTO(produtoSalvo.getId(), produtoSalvo.getNome(), produtoSalvo.getPreco(), produtoSalvo.getQuantidade());
    }

    @Override
    public List<ProdutoResponseDTO> listarTodososProdutos() {
        List<Produto> produtos = produtoRepository.findAll();

        return produtos.stream()
                .map(produto -> new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco(), produto.getQuantidade()))
                .collect(Collectors.toList());
    }

    @Override
    public void deletarProduto(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ProductNotFoundException("Produto com id " + id + " não foi encontrado");
        }
        produtoRepository.deleteById(id);
    }
}
