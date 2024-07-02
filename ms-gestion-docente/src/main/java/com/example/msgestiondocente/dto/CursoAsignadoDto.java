package com.example.msgestiondocente.dto;

import com.example.msgestiondocente.entity.Docente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CursoAsignadoDto {
    private Integer id;
    private String nombreCurso;
    private String horasAcademicas;
    private Integer docente_id;
}
