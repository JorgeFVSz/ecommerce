package com.example.ecommerce.repository;

import com.example.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    boolean existsByNome(String nome);
    boolean existsById(Long id);
    Optional<Produto> findByNome(String nome);
}
