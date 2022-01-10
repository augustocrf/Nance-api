package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.CategoriaEntity;
import br.com.acrf.nance.service.CategoriaService;
import br.com.acrf.nance.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/balanco")
public class BalancoController {

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    LancamentoService lancamentoService;

    @GetMapping()
    public ResponseEntity<List<CategoriaEntity>> get(@RequestParam(name="data_inicio") Optional<LocalDate> data_inicio, @RequestParam(name="data_fim") Optional<LocalDate> data_fim, @RequestParam(name="id_categoria") Optional<Long> id_categoria){
        return ResponseEntity.ok(this.categoriaService.findAll());
    }

}
