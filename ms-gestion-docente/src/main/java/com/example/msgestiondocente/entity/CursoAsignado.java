package com.example.msgestiondocente.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CursoAsignado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombreCurso;
    private String horasAcademicas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "docente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Docente detallesDocente;







}
