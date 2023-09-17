package com.venda.client.controller;

import com.venda.client.clienteService.ClienteService;
import com.venda.client.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
@RestController
@RequestMapping("/cliente")
public class Controller {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> detalhar(@PathVariable Long id) {
        ClienteDto dto  = service.obterPorId(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ClienteDto> cadastrar(@RequestBody ClienteDto dto, UriComponentsBuilder uriBuilder){
        ClienteDto cliente  = service.criarCliente(dto);
        URI endereco  = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(endereco).body(cliente);
    }
}
