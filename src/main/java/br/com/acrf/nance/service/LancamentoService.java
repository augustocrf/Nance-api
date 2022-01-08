package br.com.acrf.nance.service;

import br.com.acrf.nance.entity.LancamentoEntity;
import br.com.acrf.nance.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {
    private LancamentoRepository lancamentoRepository;

    @Autowired
    public LancamentoService(LancamentoRepository lancamentoRepository){
        this.lancamentoRepository = lancamentoRepository;
    }

    public LancamentoEntity save(LancamentoEntity lancamentoEntity){
        return this.lancamentoRepository.save(lancamentoEntity);
    }

    public LancamentoEntity update(LancamentoEntity lancamentoEntity){
        return this.lancamentoRepository.save(lancamentoEntity);
    }

    public void deleteByID(Long id_lancamento)
    {
        this.lancamentoRepository.deleteById(id_lancamento);
    }

    public List<LancamentoEntity> findAll(){
        return this.lancamentoRepository.findAll();
    }

    public Optional<LancamentoEntity> findByID(Long id_lancamento){
        return this.lancamentoRepository.findById(id_lancamento);
    }
}
