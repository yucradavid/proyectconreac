package com.example.msreporte.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MatriculaDto {
    private Integer id;
    private LocalDate fechaMatricula;
    private String estado;
    private Integer estudianteId;
    private EstudianteDto estudianteDto;


}
