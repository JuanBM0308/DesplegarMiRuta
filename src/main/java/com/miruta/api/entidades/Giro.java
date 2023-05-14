package com.miruta.api.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "giros")
public class Giro implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGir;

    @Column(nullable = false)
    private float longitudGir;

    @Column(nullable = false)
    private float latitudGir;



    //Relaciones
    @OneToMany(mappedBy = "giros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GiroHasRuta> giroHasRuta;



    //Constructores
    public Giro() {
    }

    public Giro(Long idGir, float longitudGir, float latitudGir) {
        this.idGir = idGir;
        this.longitudGir = longitudGir;
        this.latitudGir = latitudGir;
    }



    //Getters
    public Long getIdGir() {
        return idGir;
    }

    public float getLongitudGir() {
        return longitudGir;
    }

    public float getLatitudGir() {
        return latitudGir;
    }

    public Set<GiroHasRuta> getGiroHasRuta() {
        return giroHasRuta;
    }



    //Setters
    public void setIdGir(Long idGir) {
        this.idGir = idGir;
    }

    public void setLongitudGir(float longitudGir) {
        this.longitudGir = longitudGir;
    }

    public void setLatitudGir(float latitudGir) {
        this.latitudGir = latitudGir;
    }

    public void setGiroHasRuta(Set<GiroHasRuta> giroHasRuta) {
        this.giroHasRuta = giroHasRuta;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Giro{" +
                "idGir=" + idGir +
                ", longitudGir=" + longitudGir +
                ", latitudGir=" + latitudGir +
                ", giroHasRuta=" + giroHasRuta +
                '}';
    }
}
