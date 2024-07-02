package com.example.msreporte.feign;



import com.example.msreporte.dto.DocenteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-gestiondocentes-service", path = "/docente")
public interface GestionDocenteFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "docentePorIdCB", fallbackMethod = "fallbackDocente")
    public ResponseEntity<DocenteDto> buscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<DocenteDto> fallbackDocente(Integer id, Exception e) {
        return ResponseEntity.ok(new DocenteDto());
    }
}
