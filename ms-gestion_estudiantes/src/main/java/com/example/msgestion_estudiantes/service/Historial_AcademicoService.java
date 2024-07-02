package com.example.msgestion_estudiantes.service;


import com.example.msgestion_estudiantes.entity.Historial_Academico;


import java.util.List;
import java.util.Optional;

public interface Historial_AcademicoService {
    List<Historial_Academico> lista();
    Historial_Academico guardar(Historial_Academico historial_academico);
    Optional<Historial_Academico> buscarPorId(Integer id);
    Historial_Academico actualizar(Historial_Academico historial_academico);
    void eleminar(Integer id);
}
