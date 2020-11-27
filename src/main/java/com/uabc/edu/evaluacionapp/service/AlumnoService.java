package com.uabc.edu.evaluacionapp.service;

import com.uabc.edu.evaluacionapp.entity.Alumno;
import com.uabc.edu.evaluacionapp.entity.Intendente;

import java.util.List;

public interface AlumnoService {
    public boolean registrarAlumno(Alumno alum);
    public boolean modificarAlumno(Alumno alum);
    public boolean eliminarAlumno(Integer id);
    public List<Alumno> obtenerAlumnos();
    public Alumno obtenerAlumno(Integer id);
}