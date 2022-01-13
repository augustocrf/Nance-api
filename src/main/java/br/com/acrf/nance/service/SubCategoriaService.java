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

    public SubCategoriaEntity update(Long id_subcategoria, SubCategoriaEntity subCategoriaEntity) throws Exception {
        verifyIfExists(id_subcategoria);

        subCategoriaEntity.setId_subcategoria(id_subcategoria);

        return this.subCategoriaRepository.save(subCategoriaEntity);
    }

    public void deleteByID(Long id_subcategoria) throws Exception {
        verifyIfExists(id_subcategoria);

        this.subCategoriaRepository.deleteById(id_subcategoria);
    }

    public List<SubCategoriaEntity> findAll(){
        return this.subCategoriaRepository.findAll();
    }

    public Optional<SubCategoriaEntity> findByID(Long id_subcategoria){
        return this.subCategoriaRepository.findById(id_subcategoria);
    }

    public SubCategoriaEntity verifyIfExists(Long id_subcategoria) throws Exception{
        return this.subCategoriaRepository.findById(id_subcategoria)
                .orElseThrow(() -> new Exception(String.format("Subcategoria com o número %s não localizada! ",id_subcategoria)));
    }
}
