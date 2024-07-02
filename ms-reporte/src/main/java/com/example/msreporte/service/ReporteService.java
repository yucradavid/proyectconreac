package com.example.msreporte.service;


import com.example.msreporte.entity.Reporte;

import java.util.List;
import java.util.Optional;

public interface ReporteService {
    List<Reporte> lista();
    Reporte guardar(Reporte reporte);
    Optional<Reporte> buscarPorId(Integer id);
    Reporte actualizar(Reporte reporte);
    void eleminar(Integer id);
}
