package com.example.msgestiondocente.controller;



import com.example.msgestiondocente.dto.CursoAsignadoDto;
import com.example.msgestiondocente.entity.CursoAsignado;
import com.example.msgestiondocente.service.CursoAsignadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/asignatura")
public class CursoAsignadoController {
    @Autowired
    private CursoAsignadoService cursoAsignadoService;

    @GetMapping
    ResponseEntity<List<CursoAsignado>> lista(){
        return ResponseEntity.ok(cursoAsignadoService.lista());
    }
    @PostMapping
    ResponseEntity<CursoAsignado> guardar(@RequestBody CursoAsignadoDto cursoAsignadoDto) {
        return ResponseEntity.ok(cursoAsignadoService.guardar((cursoAsignadoDto)));
    }

    @GetMapping("/{id}")
    ResponseEntity<CursoAsignado> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(cursoAsignadoService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<CursoAsignado> actualizar(@RequestBody CursoAsignadoDto cursoAsignadoDto){
        return ResponseEntity.ok(cursoAsignadoService.actualizar((cursoAsignadoDto)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<CursoAsignado>> eleminar(@PathVariable(required = true) Integer id){
        cursoAsignadoService.eleminar(id);
        return ResponseEntity.ok(cursoAsignadoService.lista());

    }
}
