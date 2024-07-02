package com.example.msreporte.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class RegistroAsistenciaDto {
    private Integer id;
    private LocalDate fecha;
    private String estado;
    private String observaciones;
    private Integer Estudianteid;
    private Integer Docenteid;

    private DocenteDto docenteDto;
    private EstudianteDto estudianteDto;



}
