package br.com.acrf.nance.service;

import br.com.acrf.nance.entity.*;
import br.com.acrf.nance.repository.CategoriaRepository;
import br.com.acrf.nance.repository.LancamentoRepository;
import br.com.acrf.nance.repository.SubCategoriaRepository;
import br.com.acrf.nance.type.LancamentoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BalancoService {
    private LancamentoRepository lancamentoRepository;
    private SubCategoriaRepository subCategoriaRepository;
    private CategoriaRepository categoriaRepository;

    @Autowired
    public BalancoService(LancamentoRepository lancamentoRepository, SubCategoriaRepository subCategoriaRepository,
                            CategoriaRepository categoriaRepository){
        this.lancamentoRepository = lancamentoRepository;
        this.subCategoriaRepository = subCategoriaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public BalancoEntity get(LocalDate data_inicio, LocalDate data_fim, Long id_categoria){
        BalancoEntity balancoEntity = new BalancoEntity();
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        BigDecimal valorTotalDespesa = BigDecimal.valueOf(0l);

        // Buscar a Receita antes do filtro de categoria
        BigDecimal valorTotalReceita = this.lancamentoRepository.getReceita(data_inicio,data_fim);

        // Buscar a Despesa e filtro de categoria
        if (id_categoria > 0) {
            categoriaEntity = this.categoriaRepository.getById(id_categoria);

            CategoriaDTOEntity categoriaDTOEntity = new CategoriaDTOEntity(categoriaEntity.getId_categoria(),
                                                                        categoriaEntity.getNome());
            balancoEntity.setCategoriaEntity(categoriaDTOEntity);

            valorTotalDespesa = this.lancamentoRepository.getDespesa(data_inicio, data_fim, id_categoria);

        } else  { valorTotalDespesa = this.lancamentoRepository.getDespesa(data_inicio,data_fim); }

        BigDecimal valorSaldo = valorTotalReceita.subtract(valorTotalDespesa);

        balancoEntity.setDespesa(valorTotalDespesa);
        balancoEntity.setReceita(valorTotalReceita);
        balancoEntity.setSaldo(valorSaldo);

        return balancoEntity;
    }
}
