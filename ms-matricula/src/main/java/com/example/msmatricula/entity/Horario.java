package com.example.msmatricula.entity;

import com.example.msmatricula.dto.EstudianteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String curso;
    private String descripcion;
    private String GradoDesigando;
    private Integer estudianteId;

    @Transient
    private EstudianteDto estudianteDto ;



}
