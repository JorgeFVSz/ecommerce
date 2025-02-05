package com.example.ecommerce.service;

import com.example.ecommerce.dto.CompraRequestDTO;
import com.example.ecommerce.exception.CustomerNotFoundException;
import com.example.ecommerce.exception.OutOfStockException;
import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.Cliente;
import com.example.ecommerce.model.Produto;
import com.example.ecommerce.repository.ClienteRepository;
import com.example.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraServiceImp implements CompraService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    @Transactional
    public String comprar(CompraRequestDTO compraRequestDTO) {
        Cliente cliente = clienteRepository.findByCpf(compraRequestDTO.getCpf())
                .orElseThrow(() -> new CustomerNotFoundException("Cliente com cpf " + compraRequestDTO.getCpf() + " não foi encontrado."));

        List<String> produtosIndisponiveis = new ArrayList<>();

        for (Produto produtoComprado : compraRequestDTO.getProdutos()) {
            Produto produto = produtoRepository.findByNome(produtoComprado.getNome())
                    .orElseThrow(() -> new ProductNotFoundException("Produto " + produtoComprado.getNome() + " não encontrado."));

            if (produto.getQuantidade() <= 0) {
                produtosIndisponiveis.add(produto.getNome());
            }
        }

        if (!produtosIndisponiveis.isEmpty()) {
            throw new OutOfStockException("Produtos em falta: " + String.join(", ", produtosIndisponiveis));
        }

        for (Produto produtoComprado : compraRequestDTO.getProdutos()) {
            Produto produto = produtoRepository.findByNome(produtoComprado.getNome())
                    .orElseThrow(() -> new ProductNotFoundException("Produto " + produtoComprado.getNome() + " não encontrado."));

            produto.setQuantidade(produto.getQuantidade() - 1);
            produtoRepository.save(produto);
        }

        return "Compra realizada com sucesso!";
    }
}
