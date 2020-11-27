package com.uabc.edu.evaluacionapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="intendente")
public class Intendente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_intendente")
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
