package com.uabc.edu.evaluacionapp.service.impl;

import com.uabc.edu.evaluacionapp.entity.Intendente;
import com.uabc.edu.evaluacionapp.repository.IntendenteRepository;
import com.uabc.edu.evaluacionapp.service.IntendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class IntendenteServiceImpl implements IntendenteService {
    @Autowired
    IntendenteRepository repo;

    @Override
    public boolean registrarIntendente(Intendente inte) {
        try {
            repo.save(inte);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean modificarIntendente(Intendente inte) {
        try {
            repo.save(inte);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean eliminarIntendente(Integer id) {
        try {
            repo.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public List<Intendente> obtenerIntendentes() {
        //Convertir Iterador a Lista
        Iterable<Intendente> ite = repo.findAll();
        Iterator<Intendente> it = ite.iterator();
        List<Intendente> actualList = new ArrayList<Intendente>();
        while (it.hasNext()) {
            actualList.add(it.next());
        }

        return actualList;
    }

    @Override
    public Intendente obtenerIntendente(Integer id) {
        Optional<Intendente> intendente = repo.findById(id);
        if (intendente.isPresent()){
            return intendente.get();
        } else {
            throw new RuntimeException("hola");
        }
    }
}
