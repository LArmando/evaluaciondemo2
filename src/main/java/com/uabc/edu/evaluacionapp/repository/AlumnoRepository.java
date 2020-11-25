package com.uabc.edu.evaluacionapp.repository;

import com.uabc.edu.evaluacionapp.entity.Alumno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

}
