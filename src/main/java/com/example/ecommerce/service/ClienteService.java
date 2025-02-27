package com.example.ecommerce.service;

import com.example.ecommerce.dto.ClienteRequestDTO;
import com.example.ecommerce.dto.ClienteResponseDTO;

public interface ClienteService {
    ClienteResponseDTO criarCliente(ClienteRequestDTO clienteRequestDTO);
    ClienteResponseDTO buscarClientePorCpf(String cpf);
    ClienteResponseDTO atualizarDadosDoCliente(String cpf, ClienteRequestDTO clienteRequestDTO);
}
