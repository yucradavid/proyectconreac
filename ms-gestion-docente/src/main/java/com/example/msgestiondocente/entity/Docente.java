package com.example.msgestiondocente.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String especialidad;
/*
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id")
    private List<CursoAsignado> cursosAsignados;*/







}
