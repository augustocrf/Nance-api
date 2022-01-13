package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.SubCategoriaEntity;
import br.com.acrf.nance.service.SubCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/subcategoria")
public class SubCategoriaController {
    @Autowired
    SubCategoriaService subCategoriaService;

    @PostMapping()
    public ResponseEntity<SubCategoriaEntity> create(@RequestBody SubCategoriaEntity subCategoriaEntity){
        return ResponseEntity.ok(this.subCategoriaService.save(subCategoriaEntity));
    }

    @PutMapping()
    public ResponseEntity<SubCategoriaEntity> update(@PathVariable("id_subcategoria") Long id_subcategoria,
                                                     @RequestBody SubCategoriaEntity subCategoriaEntity) throws Exception {
        return ResponseEntity.ok(this.subCategoriaService.update(id_subcategoria, subCategoriaEntity));
    }

    @DeleteMapping("/{id_subcategoria}")
    public ResponseEntity<String> deleteByID(@PathVariable("id_subcategoria") Long id_subcategoria) throws  Exception{
        try {
            this.subCategoriaService.deleteByID(id_subcategoria);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<SubCategoriaEntity>> getAll(){
        return ResponseEntity.ok(this.subCategoriaService.findAll());
    }

    @GetMapping("{id_subcategoria}")
    public ResponseEntity<SubCategoriaEntity> getByID(@PathVariable("id_subcategoria") Long id_subcategoria ) throws Exception{
        return ResponseEntity.ok(this.subCategoriaService.findByID(id_subcategoria).orElseThrow(() -> new Exception("Subcategoria não encontrada")));
    }
}
