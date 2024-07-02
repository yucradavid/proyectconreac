
package com.example.msreporte.feign;



import com.example.msreporte.dto.RegistroAsistenciaDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-monitoreoasistencia-service", path = "/registroasistencia")
public interface MonitoreoAsistenciaFeign {

    @GetMapping("/{id}")
    @CircuitBreaker(name = "monitoreoPorIdCB", fallbackMethod = "fallbackRegistroAsistencia")
    public ResponseEntity<RegistroAsistenciaDto> buscarPorId(@PathVariable(required = true) Integer id);

    default ResponseEntity<RegistroAsistenciaDto> fallbackRegistroAsistencia(Integer id, Exception e) {
        return ResponseEntity.ok(new RegistroAsistenciaDto());
    }
}
