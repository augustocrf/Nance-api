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

    public CategoriaEntity update(Long id_categoria, CategoriaEntity categoriaEntity) throws Exception {

        verifyIfExists(id_categoria);

        categoriaEntity.setId_categoria(id_categoria);

        return this.categoriaRepository.save(categoriaEntity);
    }

    public void deleteByID(Long id_categoria) throws Exception {
        verifyIfExists(id_categoria);

        this.categoriaRepository.deleteById(id_categoria);
    }

    public List<CategoriaEntity> findAll(){
        return this.categoriaRepository.findAll();
    }

    public Optional<CategoriaEntity> findByID(Long id_categoria){
        return this.categoriaRepository.findById(id_categoria);
    }

    public CategoriaEntity verifyIfExists(Long id_categoria) throws Exception{
        return this.categoriaRepository.findById(id_categoria)
                .orElseThrow(() -> new Exception(String.format("Categoria com o número %s não localizada! ",id_categoria)));
    }
}
