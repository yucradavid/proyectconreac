package com.example.msmatricula.service;


import com.example.msmatricula.entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface MatriculaService {
    List<Matricula> lista();
    Matricula guardar(Matricula matricula);
    Optional<Matricula> buscarPorId(Integer id);
    Matricula actualizar(Matricula matricula);
    void eleminar(Integer id);
}
