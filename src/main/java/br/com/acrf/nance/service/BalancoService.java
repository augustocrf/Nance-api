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
        BalancoEntity balancoEntityOptional = new BalancoEntity();
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        List<LancamentoEntity> lancamentoEntityList = new ArrayList<>();
        List<SubCategoriaEntity> subCategoriaEntityList = new ArrayList<>();

        LocalDate data_teste = data_inicio.plusDays(-1l);
        lancamentoEntityList = this.lancamentoRepository.findAll()
                        .stream().filter(l -> l.getData().isAfter(data_inicio.plusDays(-1l))
                                        && l.getData().isBefore(data_fim.plusDays(1))
                                                ).collect(Collectors.toList());

        // Buscar a Receita antes do filtro de categoria
        BigDecimal valorTotalReceita = lancamentoEntityList.stream()
                .filter(l -> l.getLancamentoType() == LancamentoType.RECEITA)
                .map(la -> la.getValor())
                .reduce(BigDecimal.valueOf(0),BigDecimal::add);

        if (id_categoria > 0) {
            categoriaEntity = this.categoriaRepository.getById(id_categoria);

            CategoriaDTOEntity categoriaDTOEntity = new CategoriaDTOEntity(categoriaEntity.getId_categoria(), categoriaEntity.getNome());
            balancoEntityOptional.setCategoriaEntity(categoriaDTOEntity);

            subCategoriaEntityList = this.subCategoriaRepository.findAll().stream()
                    .filter(s -> s.getId_categoria().equals(id_categoria)).collect(Collectors.toList());

            List<Long> subCategoriaEntityList1
                    = this.subCategoriaRepository.findAll().stream()
                    .filter(s -> s.getId_categoria().equals(id_categoria))
                    .map(su -> su.getId_subcategoria()).collect(Collectors.toList());

            lancamentoEntityList = lancamentoEntityList.stream()
                    .filter(l -> subCategoriaEntityList1.contains(l.getId_subcategoria())).collect(Collectors.toList());
        }
        BigDecimal valorTotalDespesa = lancamentoEntityList.stream()
                .filter(l -> l.getLancamentoType() == LancamentoType.DESPESA)
                .map(la -> la.getValor())
                .reduce(BigDecimal.valueOf(0),BigDecimal::add);

        BigDecimal valorSaldo = valorTotalReceita.subtract(valorTotalDespesa);

        balancoEntityOptional.setDespesa(valorTotalDespesa);
        balancoEntityOptional.setReceita(valorTotalReceita);
        balancoEntityOptional.setSaldo(valorSaldo);

        return balancoEntityOptional;
    }
}
