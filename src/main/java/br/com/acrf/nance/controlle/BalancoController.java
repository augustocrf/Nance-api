package br.com.acrf.nance.controlle;

import br.com.acrf.nance.entity.BalancoEntity;
import br.com.acrf.nance.service.BalancoService;
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
    BalancoService balancoService;

    @GetMapping()
    public ResponseEntity<BalancoEntity> get(@RequestParam(name="data_inicio") LocalDate data_inicio, @RequestParam(name="data_fim") LocalDate data_fim, @RequestParam(name="id_categoria") Optional<Long> id_categoria){
        return ResponseEntity.ok(this.balancoService.get(data_inicio, data_fim, id_categoria.orElse(0l)));
    }

}
