package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProdutoRequestDTO;
import com.example.ecommerce.dto.ProdutoResponseDTO;
import com.example.ecommerce.service.ProdutoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criarProduto(@Valid @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        ProdutoResponseDTO produtoResponseDTO = produtoService.criarProduto(produtoRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> listarTodososProdutos() {
        List<ProdutoResponseDTO> produtoResponseDTO = produtoService.listarTodososProdutos();
        return ResponseEntity.ok(produtoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
