package com.venda.client.clienteService;

import com.venda.client.dto.ClienteDto;
import com.venda.client.model.Cliente;
import com.venda.client.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<ClienteDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map( v-> modelMapper.map(v, ClienteDto.class));
    }

    public ClienteDto criarCliente(ClienteDto dto) {
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        repository.save(cliente);
        return dto;
    }

    public ClienteDto obterPorId(Long id) {
        Cliente cliente = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(cliente, ClienteDto.class);
    }
}
