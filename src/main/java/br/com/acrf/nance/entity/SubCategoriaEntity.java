package br.com.acrf.nance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoriaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subcategoria;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Long id_categoria;

}
