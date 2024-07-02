package com.example.msmatricula.service;


import com.example.msmatricula.entity.Horario;

import java.util.List;
import java.util.Optional;

public interface HorarioService {
    List<Horario> lista();
    Horario guardar(Horario horario);
    Optional<Horario> buscarPorId(Integer id);
    Horario actualizar(Horario horario);
    void eleminar(Integer id);
}
