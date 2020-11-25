package com.uabc.edu.evaluacionapp.repository;

import com.uabc.edu.evaluacionapp.entity.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {

}