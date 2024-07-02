package com.example.msreporte.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DocenteDto {
    private Integer id;
    private String nombreCompleto;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;
    private String especialidad;

    private MatriculaDto Matricula;
}
