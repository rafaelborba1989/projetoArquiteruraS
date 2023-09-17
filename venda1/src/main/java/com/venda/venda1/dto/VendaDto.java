package com.venda.venda1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class VendaDto {
    private Long id;

    private BigDecimal valor;


    private String codigo;

    private Long idProduto;

    private Long idCliente;
}
