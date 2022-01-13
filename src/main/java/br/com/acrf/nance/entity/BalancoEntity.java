package br.com.acrf.nance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancoEntity {

    private CategoriaDTOEntity categoriaEntity;
    private BigDecimal receita;
    private BigDecimal despesa;
    private BigDecimal saldo;
}

