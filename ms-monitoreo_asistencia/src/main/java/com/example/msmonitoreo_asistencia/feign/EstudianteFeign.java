package com.example.msmonitoreo_asistencia.feign;


//import com.example.msmonitoreo_asistencia.dto.DocenteDto;
import com.example.msmonitoreo_asistencia.dto.EstudianteDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-gestionestudiantes-service", path = "/estudiantes")
public interface EstudianteFeign {
    @GetMapping("/{id}")
    @CircuitBreaker(name = "clienteListarPorIdCB", fallbackMethod = "fallbackEstudiante")
    public ResponseEntity<EstudianteDto> buscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<EstudianteDto> fallbackEstudiante(Integer id, Exception e) {


        return ResponseEntity.ok(new EstudianteDto());
    }
}
