package br.com.acrf.nance.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id da Categoria - IDENTITY",name="id_categoria",required=true)
    private Long id_categoria;

    @Column(nullable = false)
    @ApiModelProperty(notes = "nome da Categoria",name="nome",required=true)
    private String nome;
}
