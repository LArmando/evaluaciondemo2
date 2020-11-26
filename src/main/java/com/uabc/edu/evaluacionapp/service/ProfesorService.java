package com.uabc.edu.evaluacionapp.service;

import com.uabc.edu.evaluacionapp.entity.Profesor;

import java.util.List;

public interface ProfesorService {
    public boolean registrarProfesor(Profesor prof);
    public boolean modificarProfesor(Profesor prof);
    public List<Profesor> obtenerProfesores();
    //public boolean eliminarProfesor(Profesor prof);
}
