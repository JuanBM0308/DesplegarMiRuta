package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "paradasHasRutas")
public class ParadaHasRuta implements Serializable{

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParHasRut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idPar", referencedColumnName = "idPar", nullable = false)
    @JsonIgnore
    private Parada paradas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRut", referencedColumnName = "idRut", nullable = false)
    @JsonIgnore
    private Ruta rutas;


    //Constructores
    public ParadaHasRuta() {
    }

    public ParadaHasRuta(Long idParHasRut, Parada paradas, Ruta rutas) {
        this.idParHasRut = idParHasRut;
        this.paradas = paradas;
        this.rutas = rutas;
    }



    //Getters
    public Long getIdParHasRut() {
        return idParHasRut;
    }

    public Parada getParadas() {
        return paradas;
    }

    public Ruta getRutas() {
        return rutas;
    }



    //Setters
    public void setIdParHasRut(Long idParHasRut) {
        this.idParHasRut = idParHasRut;
    }

    public void setParadas(Parada paradas) {
        this.paradas = paradas;
    }

    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "ParadaHasRuta{" +
                "idParHasRut=" + idParHasRut +
                ", paradas=" + paradas +
                ", rutas=" + rutas +
                '}';
    }
}
