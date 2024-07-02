package com.example.msgestion_estudiantes.controller;

import com.example.msgestion_estudiantes.entity.Historial_Academico;
import com.example.msgestion_estudiantes.service.Historial_AcademicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/historialacademico")
public class Historial_AcademicoController {
    @Autowired
    private Historial_AcademicoService historialacademicoService;

    @GetMapping
    ResponseEntity<List<Historial_Academico>> lista(){
        return ResponseEntity.ok(historialacademicoService.lista());
    }
    @PostMapping
    ResponseEntity<Historial_Academico> guardar(@RequestBody Historial_Academico historial_academico){
        return ResponseEntity.ok(historialacademicoService.guardar((historial_academico)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Historial_Academico> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(historialacademicoService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<Historial_Academico> actualizar(@RequestBody Historial_Academico historial_academico){
        return ResponseEntity.ok(historialacademicoService.actualizar((historial_academico)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Historial_Academico>> eleminar(@PathVariable(required = true) Integer id){
        historialacademicoService.eleminar(id);
        return ResponseEntity.ok(historialacademicoService.lista());

    }
}
