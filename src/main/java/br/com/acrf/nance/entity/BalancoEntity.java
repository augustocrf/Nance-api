package br.com.acrf.nance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalancoEntity {

    @ApiModelProperty(notes = "nome da Categoria",name="nome",required=false)
    private CategoriaDTOEntity categoriaEntity;

    @ApiModelProperty(notes = "nome da Categoria",name="nome",required=true)
    private BigDecimal receita;

    @ApiModelProperty(notes = "nome da Categoria",name="nome",required=true)
    private BigDecimal despesa;

    @ApiModelProperty(notes = "nome da Categoria",name="nome",required=true)
    private BigDecimal saldo;
}

