package com.uabc.edu.evaluacionapp.service.impl;

import com.uabc.edu.evaluacionapp.entity.Profesor;
import com.uabc.edu.evaluacionapp.repository.ProfesorRepository;
import com.uabc.edu.evaluacionapp.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {
    @Autowired
    ProfesorRepository repo;

    @Override
    public boolean registrarProfesor(Profesor prof) {
        try {
            repo.save(prof);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modificarProfesor(Profesor prof) {
        try {
            repo.save(prof);
        } catch (Exception e) {
            return false;
        }
        return true;
        /*Optional<Profesor> profesor = repo.findById(prof.getId());
        if(profesor.isPresent()){
            Profesor nuevoProf = profesor.get();
            nuevoProf.setNombre(prof.getNombre());
            nuevoProf.setApPaterno(prof.getApPaterno());
            nuevoProf.setApMaterno(prof.getApMaterno());
            try {
                repo.save(nuevoProf);
            } catch (Exception e) {
                return false;
            }
            return true;
        } else {
            try {
                repo.save(prof);
            } catch (Exception e) {
                return false;
            }
            return true;
        }*/
    }

    @Override
    public boolean eliminarProfesor(Integer id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Profesor> obtenerProfesores() {
        //Convertir Iterador a Lista
        Iterable<Profesor> ite = repo.findAll();
        Iterator<Profesor> it = ite.iterator();
        List<Profesor> actualList = new ArrayList<Profesor>();
        while (it.hasNext()) {
            actualList.add(it.next());
        }

        return actualList;
    }

    @Override
    public Profesor obtenerProfesor(Integer id) {
        Optional<Profesor> profesor = repo.findById(id);
        if (profesor.isPresent()){
            return profesor.get();
        } else {
            throw new RuntimeException("hola");
        }
    }
}
