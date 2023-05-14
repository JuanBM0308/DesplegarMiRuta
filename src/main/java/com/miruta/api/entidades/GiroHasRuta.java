package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "girosHasRutas")
public class GiroHasRuta implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGirHasRut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idGir", referencedColumnName = "idGir", nullable = false)
    @JsonIgnore
    private Giro giros;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRut", referencedColumnName = "idRut", nullable = false)
    @JsonIgnore
    private Ruta rutas;

    @Column(nullable = false)
    private Long ordenGirHasRut;



    //Constructores
    public GiroHasRuta() {
    }

    public GiroHasRuta(Long idGirHasRut, Giro giros, Ruta rutas, Long ordenGirHasRut) {
        this.idGirHasRut = idGirHasRut;
        this.giros = giros;
        this.rutas = rutas;
        this.ordenGirHasRut = ordenGirHasRut;
    }



    //Getters
    public Long getIdGirHasRut() {
        return idGirHasRut;
    }

    public Giro getGiros() {
        return giros;
    }

    public Ruta getRutas() {
        return rutas;
    }

    public Long getOrdenGirHasRut() {
        return ordenGirHasRut;
    }



    //Setters
    public void setIdGirHasRut(Long idGirHasRut) {
        this.idGirHasRut = idGirHasRut;
    }

    public void setGiros(Giro giros) {
        this.giros = giros;
    }

    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }

    public void setOrdenGirHasRut(Long ordenGirHasRut) {
        this.ordenGirHasRut = ordenGirHasRut;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "GiroHasRuta{" +
                "idGirHasRut=" + idGirHasRut +
                ", giros=" + giros +
                ", rutas=" + rutas +
                ", ordenGirHasRut=" + ordenGirHasRut +
                '}';
    }
}
