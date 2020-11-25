package com.uabc.edu.evaluacionapp.repository;

import com.uabc.edu.evaluacionapp.entity.Intendente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntendenteRepository extends CrudRepository<Intendente, Integer> {

}
