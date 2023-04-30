package com.miruta.api.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "buses")
public class Bus implements Serializable {

    //Atributos
    @Id
    @Column(unique = true, length = 45)
    private String placaBus;



    //Relaciones
    @OneToMany(mappedBy = "buses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BusHasRuta> busHasRuta;



    //Constructores
    public Bus() {
    }

    public Bus(String placaBus) {
        this.placaBus = placaBus;
    }



    //Getters
    public String getPlacaBus() {
        return placaBus;
    }

    public Set<BusHasRuta> getBusHasRuta() {
        return busHasRuta;
    }



    //Setters
    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public void setBusHasRuta(Set<BusHasRuta> busHasRuta) {
        this.busHasRuta = busHasRuta;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Bus{" +
                "placaBus='" + placaBus + '\'' +
                '}';
    }
}
