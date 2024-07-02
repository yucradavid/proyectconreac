package com.example.msgestion_estudiantes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String DNI;
    private String direccion;
    private String telefono;
    private String email;
    private String gradoActual;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "estudiante"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "estudiante")
    private List<Historial_Academico> historialAcademicos;
}
