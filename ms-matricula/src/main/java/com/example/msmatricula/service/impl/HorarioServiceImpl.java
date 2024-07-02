package com.example.msmatricula.service.impl;


import com.example.msmatricula.entity.Horario;
import com.example.msmatricula.repository.HorarioRepository;
import com.example.msmatricula.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioServiceImpl implements HorarioService {
    @Autowired
    private HorarioRepository horarioRepository;


    @Override
    public List<Horario> lista() {
        return horarioRepository.findAll();
    }

    @Override
    public Horario guardar(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public Optional<Horario> buscarPorId(Integer id) {
        return horarioRepository.findById(id);
    }

    @Override
    public Horario actualizar(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    public void eleminar(Integer id) {
        horarioRepository.deleteById(id);

    }
}
