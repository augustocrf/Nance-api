package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.LancamentoEntity;
import br.com.acrf.nance.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lancamento")
public class LancamentoController {
    @Autowired
    LancamentoService lancamentoService;

    @PostMapping()
    public ResponseEntity<LancamentoEntity> create(@RequestBody LancamentoEntity lancamentoEntity){
        return ResponseEntity.ok(this.lancamentoService.save(lancamentoEntity));
    }

    @PutMapping()
    public ResponseEntity<LancamentoEntity> update(@RequestBody LancamentoEntity lancamentoEntity){
        return ResponseEntity.ok(this.lancamentoService.update(lancamentoEntity));
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
        return ResponseEntity.ok(this.lancamentoService.findAll());
    }

    @GetMapping("{id_lancamento}")
    public ResponseEntity<LancamentoEntity> getByID(@PathVariable("id_lancamento") Long id_lancamento ) throws Exception{
        return ResponseEntity.ok(this.lancamentoService.findByID(id_lancamento).orElseThrow(() -> new Exception("Lançamento não encontrada")));
    }
}
