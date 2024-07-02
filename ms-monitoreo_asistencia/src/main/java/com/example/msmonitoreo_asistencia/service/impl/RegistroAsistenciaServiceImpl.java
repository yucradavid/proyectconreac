package com.example.msmonitoreo_asistencia.service.impl;


//import com.example.msmonitoreo_asistencia.dto.DocenteDto;
//import com.example.msmonitoreo_asistencia.dto.EstudianteDto;
import com.example.msmonitoreo_asistencia.entity.RegistroAsistencia;

//import com.example.msmonitoreo_asistencia.feign.GestionDocenteFeign;
//import com.example.msmonitoreo_asistencia.feign.EstudianteFeign;
import com.example.msmonitoreo_asistencia.repository.RegistroAsistenciaRepository;
import com.example.msmonitoreo_asistencia.service.RegistroAsistenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroAsistenciaServiceImpl implements RegistroAsistenciaService {
    @Autowired
    private RegistroAsistenciaRepository registroAsistenciaRepository;

    //@Autowired
    //private GestionDocenteFeign gestionDocenteFeign;
    //@Autowired
    //private EstudianteFeign estudianteFeign;

    @Override
    public List<RegistroAsistencia> lista() {
        return registroAsistenciaRepository.findAll();
    }

    @Override
    public RegistroAsistencia guardar(RegistroAsistencia registroAsistencia) {
        return registroAsistenciaRepository.save(registroAsistencia);
    }

    @Override
    public Optional<RegistroAsistencia> buscarPorId(Integer id) {
        Optional<RegistroAsistencia> registroAsistencia = registroAsistenciaRepository.findById(id);

        // Obtener información del docente
        //DocenteDto docenteDto = gestionDocenteFeign.buscarPorId(registroAsistencia.get().getDocenteid()).getBody();

        // Obtener información del estudiante
        //EstudianteDto estudianteDto = estudianteFeign.buscarPorId(registroAsistencia.get().getEstudianteid()).getBody();

        // Si se desea realizar alguna operación similar con otros objetos relacionados, se puede hacer aquí.

        // Actualizar DTOs en el registro de asistencia
        //registroAsistencia.get().setDocenteDto(docenteDto);
        //registroAsistencia.get().setEstudianteDto(estudianteDto);

        return registroAsistencia;
    }



    @Override
    public RegistroAsistencia actualizar(RegistroAsistencia registroAsistencia) {
        return registroAsistenciaRepository.save(registroAsistencia);
    }

    @Override
    public void eleminar(Integer id) {
        registroAsistenciaRepository.deleteById(id);

    }
}
