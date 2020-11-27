package com.uabc.edu.evaluacionapp.service.impl;

import com.uabc.edu.evaluacionapp.entity.Alumno;
import com.uabc.edu.evaluacionapp.entity.Intendente;
import com.uabc.edu.evaluacionapp.entity.Profesor;
import com.uabc.edu.evaluacionapp.repository.AlumnoRepository;
import com.uabc.edu.evaluacionapp.repository.ProfesorRepository;
import com.uabc.edu.evaluacionapp.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {
    @Autowired
    AlumnoRepository repo;

    @Override
    public boolean registrarAlumno(Alumno alum) {
        try {
            repo.save(alum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modificarAlumno(Alumno alum) {
        try {
            repo.save(alum);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarAlumno(Integer id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Alumno> obtenerAlumnos() {
        //Convertir Iterador a Lista
        Iterable<Alumno> ite = repo.findAll();
        Iterator<Alumno> it = ite.iterator();
        List<Alumno> actualList = new ArrayList<Alumno>();
        while (it.hasNext()) {
            actualList.add(it.next());
        }

        return actualList;
    }

    @Override
    public Intendente obtenerAlumno(Integer id) {
        return null;
    }
}
