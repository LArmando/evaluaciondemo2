package com.uabc.edu.evaluacionapp.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Intendente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nombre, apPaterno, apMaterno;
    public Intendente(){

    }
    public Intendente(String nombre, String apPaterno, String apMaterno) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
    }
}
