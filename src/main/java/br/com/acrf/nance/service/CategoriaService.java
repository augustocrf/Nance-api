package br.com.acrf.nance.service;

import br.com.acrf.nance.entity.CategoriaEntity;
import br.com.acrf.nance.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaEntity save(CategoriaEntity categoriaEntity){
        return this.categoriaRepository.save(categoriaEntity);
    }

    public CategoriaEntity update(CategoriaEntity categoriaEntity){
        return this.categoriaRepository.save(categoriaEntity);
    }

    public void deleteByID(Long id_categoria)
    {
        this.categoriaRepository.deleteById(id_categoria);
    }

    public List<CategoriaEntity> findAll(){
        return this.categoriaRepository.findAll();
    }

    public Optional<CategoriaEntity> findByID(Long id_categoria){
        return this.categoriaRepository.findById(id_categoria);
    }
}
