package com.uabc.edu.evaluacionapp.service;

import com.uabc.edu.evaluacionapp.entity.Intendente;

import java.util.List;

public interface IntendenteService {
    public boolean registrarIntendente(Intendente inte);
    public boolean modificarIntendente(Intendente inte);
    public boolean eliminarIntendente(Integer id);
    public List<Intendente> obtenerIntendentes();
    public Intendente obtenerIntendente(Integer id);
}
