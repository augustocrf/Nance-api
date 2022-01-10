package br.com.acrf.nance.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LancamentoType {

    DESPESA("Despesa"),
    RECEITA("Receita");

    private final String description;
}
