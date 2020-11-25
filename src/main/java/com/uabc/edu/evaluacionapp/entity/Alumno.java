package com.uabc.edu.evaluacionapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer matricula;
    private String nombre, apPaterno, apMaterno;

    public Alumno(){

    }

    public Alumno(String nombre, String apPaterno, String apMaterno) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }

}
