package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false)
    private Double longitudBus;

    @Column(nullable = false)
    private Double latitudBus;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "identificacionUsu", referencedColumnName = "identificacionUsu", nullable = false)
    @JsonIgnore
    private Usuario usuario;



    //Relaciones
    @OneToMany(mappedBy = "buses", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BusHasRuta> busHasRuta;



    //Constructores
    public Bus() {
    }

    public Bus(String placaBus, Double longitudBus, Double latitudBus, Usuario usuario) {
        this.placaBus = placaBus;
        this.longitudBus = longitudBus;
        this.latitudBus = latitudBus;
        this.usuario = usuario;
    }



    //Getters
    public String getPlacaBus() {
        return placaBus;
    }

    public Double getLongitudBus() {
        return longitudBus;
    }

    public Double getLatitudBus() {
        return latitudBus;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Set<BusHasRuta> getBusHasRuta() {
        return busHasRuta;
    }



    //Setters
    public void setPlacaBus(String placaBus) {
        this.placaBus = placaBus;
    }

    public void setLongitudBus(Double longitudBus) {
        this.longitudBus = longitudBus;
    }

    public void setLatitudBus(Double latitudBus) {
        this.latitudBus = latitudBus;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setBusHasRuta(Set<BusHasRuta> busHasRuta) {
        this.busHasRuta = busHasRuta;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Bus{" +
                "placaBus='" + placaBus + '\'' +
                ", longitudBus=" + longitudBus +
                ", latitudBus=" + latitudBus +
                ", usuario=" + usuario +
                ", busHasRuta=" + busHasRuta +
                '}';
    }



}
