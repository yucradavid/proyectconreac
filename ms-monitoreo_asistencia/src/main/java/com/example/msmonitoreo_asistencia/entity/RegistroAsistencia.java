package com.example.msmonitoreo_asistencia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class RegistroAsistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String estudiante;
    private String grado;
    private LocalDate fecha;
    private String asistencia;

}
