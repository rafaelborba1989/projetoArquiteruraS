package com.venda.venda1.controller;

import com.venda.venda1.dto.VendaDto;
import com.venda.venda1.model.Venda;
import com.venda.venda1.service.VendaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/vendas")
public class Controller {

    @Autowired
    private VendaService service;

    @GetMapping("/{id}")
    public ResponseEntity<VendaDto> detalhar(@PathVariable @NotNull Long id) {
        VendaDto dto  = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<VendaDto> cadastrar(@RequestBody @Valid VendaDto dto, UriComponentsBuilder uriBuilder){
        VendaDto venda  = service.criarVenda(dto);
        URI endereco  = uriBuilder.path("/vendas/{id}").buildAndExpand(venda.getId()).toUri();

        return ResponseEntity.created(endereco).body(venda);
    }

}
