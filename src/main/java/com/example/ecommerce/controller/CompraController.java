package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CompraRequestDTO;
import com.example.ecommerce.service.CompraServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraServiceImp compraServiceImp;

    @PostMapping
    ResponseEntity<String> comprar(@RequestBody CompraRequestDTO compraRequestDTO) {
        String resposta = compraServiceImp.comprar(compraRequestDTO);
        return ResponseEntity.ok().body(resposta);
    }
}
