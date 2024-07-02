package com.example.msgestion_estudiantes.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.msgestion_estudiantes.entity.Historial_Academico;
import com.example.msgestion_estudiantes.repository.Historial_AcademicoRepository;
import com.example.msgestion_estudiantes.service.Historial_AcademicoService;

import java.util.List;
import java.util.Optional;

@Service
public class Historial_AcademicoServiceImpl implements Historial_AcademicoService {
    @Autowired
    private Historial_AcademicoRepository historialacademicoRepository;

    @Override
    public List<Historial_Academico> lista() {
        return historialacademicoRepository.findAll();
    }

    @Override
    public Historial_Academico guardar(Historial_Academico historial_academico) {
        return historialacademicoRepository.save(historial_academico);
    }

    @Override
    public Optional<Historial_Academico> buscarPorId(Integer id) {
        return historialacademicoRepository.findById(id);
    }

    @Override
    public Historial_Academico actualizar(Historial_Academico historial_academico) {
        return historialacademicoRepository.save(historial_academico);
    }

    @Override
    public void eleminar(Integer id) {
        historialacademicoRepository.deleteById(id);

    }
}
