package com.example.msmatricula.service.impl;


import com.example.msmatricula.dto.EstudianteDto;
import com.example.msmatricula.entity.Horario;
import com.example.msmatricula.entity.Matricula;
import com.example.msmatricula.feign.EstudiantesFeign;
import com.example.msmatricula.repository.MatriculaRepository;
import com.example.msmatricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaServiceImpl implements MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;
    @Autowired
    private EstudiantesFeign estudiantesFeign;


    @Override
    public List<Matricula> lista() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula guardar(Matricula matricula) {

        return matriculaRepository.save(matricula);
    }

    @Override
    public Optional<Matricula> buscarPorId(Integer id) {
        Optional<Matricula> matriculaOptional = matriculaRepository.findById(id);

        if (matriculaOptional.isPresent()) {
            Matricula matricula = matriculaOptional.get();

            // Obtener el EstudianteDto y establecerlo en Matricula
            EstudianteDto estudianteDto = estudiantesFeign.buscarPorId(matricula.getEstudianteId()).getBody();
            matricula.setEstudianteDto(estudianteDto);

            // Mapear y establecer EstudianteDto en cada Horario de Matricula
            List<Horario> horarios = matricula.getDetallehorario().stream().map(horario -> {
                EstudianteDto estudianteHorarioDto = estudiantesFeign.buscarPorId(horario.getEstudianteId()).getBody();
                horario.setEstudianteDto(estudianteHorarioDto);
                return horario;
            }).toList();
            matricula.setDetallehorario(horarios);
        }

        return matriculaOptional;
    }
    @Override
    public Matricula actualizar(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public void eleminar(Integer id) {
        matriculaRepository.deleteById(id);

    }
}
