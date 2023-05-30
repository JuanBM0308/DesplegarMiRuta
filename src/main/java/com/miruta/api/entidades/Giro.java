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
    private Double longitudGir;

    @Column(nullable = false)
    private Double latitudGir;



    //Relaciones
    @OneToMany(mappedBy = "giros", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GiroHasRuta> giroHasRuta;



    //Constructores
    public Giro() {
    }

    public Giro(Long idGir, Double longitudGir, Double latitudGir) {
        this.idGir = idGir;
        this.longitudGir = longitudGir;
        this.latitudGir = latitudGir;
    }



    //Getters
    public Long getIdGir() {
        return idGir;
    }

    public Double getLongitudGir() {
        return longitudGir;
    }

    public Double getLatitudGir() {
        return latitudGir;
    }

    public Set<GiroHasRuta> getGiroHasRuta() {
        return giroHasRuta;
    }



    //Setters
    public void setIdGir(Long idGir) {
        this.idGir = idGir;
    }

    public void setLongitudGir(Double longitudGir) {
        this.longitudGir = longitudGir;
    }

    public void setLatitudGir(Double latitudGir) {
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
