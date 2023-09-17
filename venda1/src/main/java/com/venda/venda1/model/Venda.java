package com.venda.venda1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "vendas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotBlank
   private BigDecimal valor;

    @NotBlank
   private String codigo;
    @NotBlank
    private Long idProduto;
    @NotBlank
    private Long idCliente;

}
