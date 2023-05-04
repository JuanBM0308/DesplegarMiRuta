package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "busesHasRutas")
public class BusHasRuta implements Serializable{

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBusHasRut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "placaBus", referencedColumnName = "placaBus", nullable = false)
    @JsonIgnore
    private Bus buses;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRut", referencedColumnName = "idRut", nullable = false)
    @JsonIgnore
    private Ruta rutas;



    //Constructores
    public BusHasRuta() {
    }

    public BusHasRuta(Long idBusHasRut, Bus buses, Ruta rutas) {
        this.idBusHasRut = idBusHasRut;
        this.buses = buses;
        this.rutas = rutas;
    }



    //Getters
    public Long getIdBusHasRut() {
        return idBusHasRut;
    }

    public Bus getBuses() {
        return buses;
    }

    public Ruta getRutas() {
        return rutas;
    }



    //Setters
    public void setIdBusHasRut(Long idBusHasRut) {
        this.idBusHasRut = idBusHasRut;
    }

    public void setBuses(Bus buses) {
        this.buses = buses;
    }

    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "BusHasRuta{" +
                "idBusHasRut=" + idBusHasRut +
                ", buses=" + buses +
                ", rutas=" + rutas +
                '}';
    }
}
