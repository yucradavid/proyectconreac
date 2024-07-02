package com.example.msgestiondocente.service.impl;



import com.example.msgestiondocente.dto.CursoAsignadoDto;
import com.example.msgestiondocente.entity.CursoAsignado;
import com.example.msgestiondocente.entity.Docente;
import com.example.msgestiondocente.repository.CursoAsignadoRepository;
import com.example.msgestiondocente.service.CursoAsignadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CursoAsignadoServiceImpl implements CursoAsignadoService {
    @Autowired
    private CursoAsignadoRepository cursoAsignadoRepository;

    @Override
    public List<CursoAsignado> lista() {
        return cursoAsignadoRepository.findAll();
    }

    @Override
    public CursoAsignado guardar(CursoAsignadoDto cursoAsignadoDto) {
        CursoAsignado cursoAsignado = new CursoAsignado();
        Docente docente = new Docente();
        docente.setId(cursoAsignadoDto.getDocente_id());
        System.out.println("=====================");
        System.out.println(docente.toString());
        cursoAsignado.setNombreCurso(cursoAsignadoDto.getNombreCurso());
        cursoAsignado.setHorasAcademicas(cursoAsignadoDto.getHorasAcademicas());
        cursoAsignado.setDetallesDocente(docente);
        System.out.println(cursoAsignado.toString());
        return cursoAsignadoRepository.save(cursoAsignado);
    }

    @Override
    public Optional<CursoAsignado> buscarPorId(Integer id) {
        return cursoAsignadoRepository.findById(id);
    }

    @Override
    public CursoAsignado actualizar(CursoAsignadoDto cursoAsignadoDto) {

        CursoAsignado cursoAsignado = new CursoAsignado();
        Docente docente = new Docente();
        docente.setId(cursoAsignadoDto.getDocente_id());
        System.out.println("=====================");
        System.out.println(docente.toString());
        cursoAsignado.setNombreCurso(cursoAsignadoDto.getNombreCurso());
        cursoAsignado.setHorasAcademicas(cursoAsignadoDto.getHorasAcademicas());
        return cursoAsignadoRepository.save(cursoAsignado);
    }

    @Override
    public void eleminar(Integer id) {
        cursoAsignadoRepository.deleteById(id);

    }
}
