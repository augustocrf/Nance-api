package br.com.acrf.nance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "subcategoria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "ID da Subcategoria",name="id_subcategoria")
    private Long id_subcategoria;

    @Column(nullable = false)
    @ApiModelProperty(notes = "Nome da Subcategoria",name="nome",required=true)
    private String nome;

    @Column(nullable = false)
    @ApiModelProperty(notes = "ID da Categoria",name="id_categoria",required=true)
    private Long id_categoria;

}
