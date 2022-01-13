package br.com.acrf.nance.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTOEntity {
    private Long id_categoria;
    private String nome;
}