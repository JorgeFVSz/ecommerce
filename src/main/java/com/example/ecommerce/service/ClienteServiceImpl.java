package com.example.ecommerce.service;

import com.example.ecommerce.dto.ClienteRequestDTO;
import com.example.ecommerce.dto.ClienteResponseDTO;
import com.example.ecommerce.exception.DuplicateEntryException;
import com.example.ecommerce.model.Cliente;
import com.example.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;


    public ClienteResponseDTO criarCliente(ClienteRequestDTO clienteRequestDTO) {

        if (clienteRepository.existsByCpf(clienteRequestDTO.getCpf())) {
            throw new DuplicateEntryException("Cliente com cpf " + clienteRequestDTO.getCpf() + " já está cadastrado");
        }

        if(clienteRepository.existsByEmail(clienteRequestDTO.getEmail())) {
            throw new DuplicateEntryException("Cliente com email " + clienteRequestDTO.getEmail() + " já está cadastrado");
        }

        Cliente cliente = new Cliente(clienteRequestDTO.getNome(), clienteRequestDTO.getCpf(), clienteRequestDTO.getEmail());

        Cliente clienteSalvo = clienteRepository.save(cliente);

        return new ClienteResponseDTO(clienteSalvo.getId(), clienteSalvo.getNome(), clienteSalvo.getCpf(), clienteSalvo.getEmail());
    }
}
