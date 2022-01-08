package br.com.acrf.nance.service;

import br.com.acrf.nance.entity.CategoriaEntity;
import br.com.acrf.nance.entity.SubCategoriaEntity;
import br.com.acrf.nance.repository.CategoriaRepository;
import br.com.acrf.nance.repository.SubCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoriaService {

    private SubCategoriaRepository subCategoriaRepository;

    @Autowired
    public SubCategoriaService(SubCategoriaRepository subCategoriaRepository){
        this.subCategoriaRepository = subCategoriaRepository;
    }

    public SubCategoriaEntity save(SubCategoriaEntity subCategoriaEntity){
        return this.subCategoriaRepository.save(subCategoriaEntity);
    }

    public SubCategoriaEntity update(SubCategoriaEntity subCategoriaEntity){
        return this.subCategoriaRepository.save(subCategoriaEntity);
    }

    public void deleteByID(Long id_subcategoria)
    {
        this.subCategoriaRepository.deleteById(id_subcategoria);
    }

    public List<SubCategoriaEntity> findAll(){
        return this.subCategoriaRepository.findAll();
    }

    public Optional<SubCategoriaEntity> findByID(Long id_subcategoria){
        return this.subCategoriaRepository.findById(id_subcategoria);
    }
}
