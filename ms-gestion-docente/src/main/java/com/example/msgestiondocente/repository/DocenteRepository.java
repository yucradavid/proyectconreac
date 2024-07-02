package com.example.msgestiondocente.repository;


import com.example.msgestiondocente.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente,Integer> {
}
