package com.uabc.edu.evaluacionapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String nombre, apPaterno, apMaterno;

    public Profesor(){

    }

    public Profesor(String nombre, String apPaterno, String apMaterno) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }


}
