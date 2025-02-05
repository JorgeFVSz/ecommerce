package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ClienteRequestDTO;
import com.example.ecommerce.dto.ClienteResponseDTO;
import com.example.ecommerce.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteServiceImpl;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = clienteServiceImpl.criarCliente(clienteRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponseDTO);
    }

    @GetMapping("{cpf}")
    public ResponseEntity<ClienteResponseDTO> buscarClientePorCpf(@PathVariable String cpf) {
        ClienteResponseDTO clienteResponseDTO = clienteServiceImpl.buscarClientePorCpf(cpf);
        return ResponseEntity.ok(clienteResponseDTO);
    }

    @PutMapping("{cpf}")
    public ResponseEntity<ClienteResponseDTO> atualizarDadosDoCliente(@PathVariable String cpf, @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        ClienteResponseDTO clienteResponseDTO = clienteServiceImpl.atualizarDadosDoCliente(cpf, clienteRequestDTO);
        return ResponseEntity.ok(clienteResponseDTO);
    }
}
