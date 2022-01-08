package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.CategoriaEntity;
import br.com.acrf.nance.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping()
    public ResponseEntity<CategoriaEntity> create(@RequestBody CategoriaEntity categoriaEntity){
        return ResponseEntity.ok(this.categoriaService.save(categoriaEntity));
    }

    @PutMapping()
    public ResponseEntity<CategoriaEntity> update(@RequestBody CategoriaEntity categoriaEntity){
        return ResponseEntity.ok(this.categoriaService.update(categoriaEntity));
    }

    @DeleteMapping("/{id_categoria}")
    public ResponseEntity<String> deleteByID(@PathVariable("id_categoria") Long id_categoria) throws  Exception{
        try {
            this.categoriaService.deleteByID(id_categoria);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<CategoriaEntity>> getAll(){
        return ResponseEntity.ok(this.categoriaService.findAll());
    }

    @GetMapping("{id_categoria}")
    public ResponseEntity<CategoriaEntity> getByID(@PathVariable("id_categoria") Long id_categoria ) throws Exception{
        return ResponseEntity.ok(this.categoriaService.findByID(id_categoria).orElseThrow(() -> new Exception("Categoria não encontrada")));
    }
}