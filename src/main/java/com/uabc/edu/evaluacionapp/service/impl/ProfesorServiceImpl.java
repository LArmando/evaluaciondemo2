package com.uabc.edu.evaluacionapp.service.impl;

import com.uabc.edu.evaluacionapp.entity.Profesor;
import com.uabc.edu.evaluacionapp.repository.ProfesorRepository;
import com.uabc.edu.evaluacionapp.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository repo;

    @Override
    public boolean registrarProfesor(Profesor prof) {
        return false;
    }

    @Override
    public boolean modificarProfesor(Profesor prof) {
        return false;
    }

    @Override
    public List<Profesor> obtenerProfesores() {
        return null;
    }
}
