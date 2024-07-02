package com.example.msgestiondocente.service;




import com.example.msgestiondocente.dto.CursoAsignadoDto;
import com.example.msgestiondocente.entity.CursoAsignado;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CursoAsignadoService {
    List<CursoAsignado> lista();
    CursoAsignado guardar(CursoAsignadoDto cursoAsignadoDto);
    Optional<CursoAsignado> buscarPorId(Integer id);
    CursoAsignado actualizar(CursoAsignadoDto cursoAsignadoDto);
    void eleminar(Integer id);
}
