package com.example.msmatricula.entity;

import com.example.msmatricula.dto.EstudianteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fechaMatricula;
    private String estado;
    private Integer estudianteId;

    @Transient
    private EstudianteDto estudianteDto ;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "hoarario_id")
    private List<Horario> detallehorario;
}
