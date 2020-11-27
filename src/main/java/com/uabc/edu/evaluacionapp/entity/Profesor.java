package com.uabc.edu.evaluacionapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="profesor")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_profesor")

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
