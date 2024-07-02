package com.example.msreporte.service.Impl;

import java.util.List;
import java.util.Optional;

import com.example.msreporte.dto.DocenteDto;
import com.example.msreporte.dto.EstudianteDto;
import com.example.msreporte.dto.MatriculaDto;
import com.example.msreporte.dto.RegistroAsistenciaDto;
import com.example.msreporte.entity.Reporte;
import com.example.msreporte.feign.AdmatriculaFeign;
import com.example.msreporte.feign.EstudianteFeign;
import com.example.msreporte.feign.GestionDocenteFeign;
import com.example.msreporte.feign.MonitoreoAsistenciaFeign;
import com.example.msreporte.repository.ReporteRepository;
import com.example.msreporte.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ReporteServiceImpl implements ReporteService {
    @Autowired
    private ReporteRepository reporteRepository;

    @Autowired
    private GestionDocenteFeign gestionDocenteFeign;

    @Autowired
    private EstudianteFeign estudianteFeign;

    @Autowired
    private AdmatriculaFeign admatriculaFeign;

    @Autowired
    private MonitoreoAsistenciaFeign monitoreoAsistenciaFeign;

    @Override
    public List<Reporte> lista() {
        List<Reporte> reportes = reporteRepository.findAll();
        reportes.forEach(this::cargarDtoEnReporte);
        return reportes;
    }

    @Override
    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @Override
    public Optional<Reporte> buscarPorId(Integer id) {
        Optional<Reporte> optionalReporte = reporteRepository.findById(id);
        optionalReporte.ifPresent(this::cargarDtoEnReporte); // Cargar DTOs si el reporte existe
        return optionalReporte;
    }

    @Override
    public Reporte actualizar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @Override
    public void eleminar(Integer id) {
        reporteRepository.deleteById(id);
    }

    private void cargarDtoEnReporte(Reporte reporte) {
        if (reporte.getDocenteid() != null) {
            DocenteDto docenteDto = obtenerDocenteDto(reporte.getDocenteid());
            reporte.setDocenteDto(docenteDto);
        }
        if (reporte.getEstudianteid() != null) {
            EstudianteDto estudianteDto = obtenerEstudianteDto(reporte.getEstudianteid());
            reporte.setEstudianteDto(estudianteDto);
        }
        if (reporte.getMatriculaid() != null) {
            MatriculaDto matriculaDto = obtenerMatriculaDto(reporte.getMatriculaid());
            reporte.setMatriculaDto(matriculaDto);
        }
        if (reporte.getAsistenciaid() != null) {
            RegistroAsistenciaDto registroAsistenciaDto = obtenerRegistroAsistenciaDto(reporte.getAsistenciaid());
            reporte.setRegistroAsistenciaDto(registroAsistenciaDto);
        }
    }

    private DocenteDto obtenerDocenteDto(Integer id) {
        return gestionDocenteFeign.buscarPorId(id).getBody();
    }

    private EstudianteDto obtenerEstudianteDto(Integer id) {
        return estudianteFeign.buscarPorId(id).getBody();
    }

    private MatriculaDto obtenerMatriculaDto(Integer id) {
        return admatriculaFeign.buscarPorId(id).getBody();
    }

    private RegistroAsistenciaDto obtenerRegistroAsistenciaDto(Integer id) {
        return monitoreoAsistenciaFeign.buscarPorId(id).getBody();
    }
}