package com.example.ecommerce.service;

import com.example.ecommerce.dto.ClienteRequestDTO;
import com.example.ecommerce.dto.ClienteResponseDTO;
import com.example.ecommerce.exception.CustomerNotFoundException;
import com.example.ecommerce.exception.DuplicateEntryException;
import com.example.ecommerce.model.Cliente;
import com.example.ecommerce.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
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

    @Override
    public ClienteResponseDTO buscarClientePorCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente com cpf " + cpf + " não foi encontrado."));
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }

    @Override
    public ClienteResponseDTO atualizarDadosDoCliente(String cpf, ClienteRequestDTO clienteRequestDTO) {
        Cliente cliente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new CustomerNotFoundException("Cliente com cpf " + cpf + " não foi encontrado."));
        cliente.setNome(clienteRequestDTO.getNome());
        cliente.setCpf(clienteRequestDTO.getCpf());
        cliente.setEmail(clienteRequestDTO.getEmail());
        clienteRepository.save(cliente);
        return new ClienteResponseDTO(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getEmail());
    }
}
