package br.com.acrf.nance.entity;

import br.com.acrf.nance.type.LancamentoType;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "lancamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lancamento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @ApiModelProperty(notes = "Tipo Lançamento (Despesa, Receita)",name="lancamentoType",required=true)
    private LancamentoType lancamentoType;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @ApiModelProperty(notes = "Data lançamento (Default Data atual (now) format ('yyyy-mm-dd'))",name="data",required=true)
    private LocalDate data;

    @Column(nullable = false)
    @ApiModelProperty(notes = "ID da Subcategoria",name="id_subcategoria",required=true)
    private Long id_subcategoria;

    @ApiModelProperty(notes = "Comentario do lançamento",name="comentario",required=false)
    private String comentario;
}
