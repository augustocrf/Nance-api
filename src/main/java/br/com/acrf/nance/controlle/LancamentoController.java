package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.CategoriaEntity;
import br.com.acrf.nance.entity.LancamentoEntity;
import br.com.acrf.nance.service.LancamentoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lancamento")
public class LancamentoController {
    @Autowired
    LancamentoService lancamentoService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suceess|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })

    @PostMapping()
    public ResponseEntity<LancamentoEntity> create(@RequestBody LancamentoEntity lancamentoEntity){
        return new ResponseEntity<>(this.lancamentoService.save(lancamentoEntity), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<LancamentoEntity> update(@PathVariable("id_lancamento") Long id_lancamento,
                                                   @RequestBody LancamentoEntity lancamentoEntity) throws Exception {
        return new ResponseEntity<>(this.lancamentoService.update(id_lancamento, lancamentoEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id_lancamento}")
    public ResponseEntity<String> deleteByID(@PathVariable("id_lancamento") Long id_lancamento) throws  Exception{
        try {
            this.lancamentoService.deleteByID(id_lancamento);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity<List<LancamentoEntity>> getAll(){
        return new ResponseEntity<>(this.lancamentoService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id_lancamento}")
    public ResponseEntity<LancamentoEntity> getByID(@PathVariable("id_lancamento") Long id_lancamento ) throws Exception{
        return new ResponseEntity<>(this.lancamentoService.findByID(id_lancamento).orElseThrow(() -> new Exception("Lançamento não encontrada")), HttpStatus.OK);
    }
}
