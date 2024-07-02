package com.example.msmatricula.repository;


import com.example.msmatricula.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {
    
}
