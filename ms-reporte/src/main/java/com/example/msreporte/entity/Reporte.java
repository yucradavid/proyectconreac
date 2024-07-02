package com.example.msreporte.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import com.example.msreporte.dto.DocenteDto;
import com.example.msreporte.dto.EstudianteDto;
import com.example.msreporte.dto.MatriculaDto;
import com.example.msreporte.dto.RegistroAsistenciaDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private String tipo;
    private Integer docenteid;
    private Integer estudianteid;
    private Integer matriculaid;
    private Integer asistenciaid;
    @Transient
    private EstudianteDto estudianteDto ;
    @Transient
    private DocenteDto docenteDto ;
    @Transient
    private MatriculaDto matriculaDto ;
    @Transient
    private RegistroAsistenciaDto registroAsistenciaDto ;
    // Relación con Destinatario (Uno a Muchos)
    // @OneToMany(mappedBy = "mensaje", cascade = CascadeType.ALL)
    // private List<Destinatario> destinatario;

    // Relación con Notificación (Uno a Uno)
 

}