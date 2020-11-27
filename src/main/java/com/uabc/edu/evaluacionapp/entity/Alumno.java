package com.uabc.edu.evaluacionapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="alumno")
public class Alumno {
    @Id
    private Integer matricula;
    private String nombre, apPaterno, apMaterno, programa_educativo;

    public Alumno(){

    }

    public Alumno(String nombre, String apPaterno, String apMaterno, String programa_educativo) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.programa_educativo = programa_educativo;
    }

}
