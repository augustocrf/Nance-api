package br.com.acrf.nance.repository;

import br.com.acrf.nance.entity.LancamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<LancamentoEntity, Long> {
}
