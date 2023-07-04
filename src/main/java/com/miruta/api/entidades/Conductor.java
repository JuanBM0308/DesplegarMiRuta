package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "conductores")
public class Conductor {

    //Atributos
    @Id
    private Long identificacionCon;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsu", referencedColumnName = "idUsu", nullable = false)
    @JsonIgnore
    private Usuario usuario;



    //Relaciones
    @OneToOne(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bus bus;



    //Constructores
    public Conductor() {
    }

    public Conductor(Long identificacionCon, Usuario usuario) {
        this.identificacionCon = identificacionCon;
        this.usuario = usuario;
    }



    //Getters
    public Long getIdentificacionCon() {
        return identificacionCon;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Bus getBus() {
        return bus;
    }



    //Setters
    public void setIdentificacionCon(Long identificacionCon) {
        this.identificacionCon = identificacionCon;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Conductor{" +
                "identificacionCon=" + identificacionCon +
                ", usuario=" + usuario +
                ", bus=" + bus +
                '}';
    }



}
