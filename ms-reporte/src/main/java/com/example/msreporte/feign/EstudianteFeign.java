package com.example.msreporte.feign;


import com.example.msreporte.dto.EstudianteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-gestionestudiantes-service", path = "/estudiante")
public interface EstudianteFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "estudiantePorIdCB", fallbackMethod = "fallbackEstudiante")
    public ResponseEntity<EstudianteDto> buscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<EstudianteDto> fallbackEstudiante(Integer id, Exception e) {
        return ResponseEntity.ok(new EstudianteDto());
    }
}
