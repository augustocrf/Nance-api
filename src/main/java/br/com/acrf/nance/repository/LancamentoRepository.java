package br.com.acrf.nance.repository;

import br.com.acrf.nance.entity.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {
    @Query("select a from LancamentoEntity a " +
            "where a.data >= :data_inicio " +
            "and   a.data <= :data_final ")
    List<LancamentoEntity> getBalanco(@Param("data_inicio") LocalDate data_inicio,
                                      @Param("data_final") LocalDate data_final);

    @Query("select a from LancamentoEntity a " +
            "where a.data >= :data_inicio " +
            "and   a.data <= :data_final " +
            "and   a.id_subcategoria = :id_subcategoria ")
    List<LancamentoEntity> getBalanco(@Param("data_inicio") LocalDate data_inicio,
                                      @Param("data_final") LocalDate data_final,
                                      @Param("id_subcategoria") Long id_subcategoria);

    @Query("select sum(a.valor) as saldo_receita from LancamentoEntity a " +
            "where a.data >= :data_inicio " +
            "and   a.data <= :data_final " +
            "and   a.lancamentoType = 'RECEITA' ")
    BigDecimal getReceita(@Param("data_inicio") LocalDate data_inicio,
                                      @Param("data_final") LocalDate data_final);

    @Query("select sum(a.valor) as saldo_receita from LancamentoEntity a " +
            "where a.data >= :data_inicio " +
            "and   a.data <= :data_final " +
            "and   a.lancamentoType = 'DESPESA' ")
    BigDecimal getDespesa(@Param("data_inicio") LocalDate data_inicio,
                          @Param("data_final") LocalDate data_final);

    @Query("select sum(a.valor) as saldo_receita from LancamentoEntity a " +
            "inner join SubCategoriaEntity b on b.id_subcategoria = a.id_subcategoria " +
            "where a.data >= :data_inicio " +
            "and   a.data <= :data_final " +
            "and   a.lancamentoType = 'DESPESA' " +
            "and   b.id_categoria = :id_categoria ")
    BigDecimal getDespesa(@Param("data_inicio") LocalDate data_inicio,
                          @Param("data_final") LocalDate data_final,
                          @Param("id_categoria") Long id_categoria);
}
