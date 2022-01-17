package br.com.acrf.nance.controlle;

import br.com.acrf.nance.adapter.annotation.AllowAnnonymous;
import br.com.acrf.nance.entity.CategoriaEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/healthcheck")
public class HealthCheckController {

    @AllowAnnonymous
    @GetMapping()
    public ResponseEntity<String> getHealthCheck(){
        return ResponseEntity.ok ("HealthCheck Ok.");
    }
}
