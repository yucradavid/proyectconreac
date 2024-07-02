package com.example.msgestion_estudiantes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Historial_Academico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String institucion;
    private String promedio;
    private String observaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "historialAcademicos"})
    private Estudiante estudiante;
}
