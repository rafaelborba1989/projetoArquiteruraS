package com.venda.venda1.service;

import com.venda.venda1.dto.VendaDto;
import com.venda.venda1.model.Venda;
import com.venda.venda1.repository.VendaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<VendaDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map( v-> modelMapper.map(v, VendaDto.class));
    }

    public VendaDto criarVenda(VendaDto dto) {
        Venda venda = modelMapper.map(dto, Venda.class);
        repository.save(venda);
        return dto;
    }

    public VendaDto obterPorId(Long id) {
        Venda venda = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(venda, VendaDto.class);
    }

}
