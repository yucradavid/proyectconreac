package com.example.msreporte.feign;



import com.example.msreporte.dto.MatriculaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-matriculas-service", path = "/matriculas")
public interface AdmatriculaFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "admatriculaPorIdCB", fallbackMethod = "fallbackAdmatricula")
    public ResponseEntity<MatriculaDto> buscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<MatriculaDto> fallbackAdmatricula(Integer id, Exception e) {
        MatriculaDto matriculaDto = new MatriculaDto();
        matriculaDto.setId(900000); // Ejemplo de asignación de ID por defecto en caso de error
        return ResponseEntity.ok(matriculaDto);
    }
}
