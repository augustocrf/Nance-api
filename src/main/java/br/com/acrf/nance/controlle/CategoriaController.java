package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.CategoriaEntity;
import br.com.acrf.nance.service.CategoriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/categoria")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    private static Logger logger = Logger.getLogger(CategoriaController.class.getName());

    @ApiOperation(value = "Obtenha uma lista Categoria ", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @PostMapping()
    public ResponseEntity<CategoriaEntity> create(@RequestBody CategoriaEntity categoriaEntity){
        return new ResponseEntity<>(this.categoriaService.save(categoriaEntity), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<CategoriaEntity> update(@RequestBody CategoriaEntity categoriaEntity){
        return new ResponseEntity<>(this.categoriaService.update(categoriaEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id_categoria}")
    public ResponseEntity<String> deleteByID(@PathVariable("id_categoria") Long id_categoria) throws  Exception{
        try {
            this.categoriaService.deleteByID(id_categoria);
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
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