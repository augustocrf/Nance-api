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
    private LocalDate data;

    @Column(nullable = false)
    private Long id_subcategoria;

    private String comentario;
}
