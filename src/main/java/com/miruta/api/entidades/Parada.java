package com.miruta.api.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "paradas")
public class Parada implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPar;

    @Column(length = 45, nullable = false)
    private String nombrePar;

    @Column(length = 200, nullable = false)
    private String direccionPar;

    @Column(nullable = false)
    private float longitudPar;

    @Column(nullable = false)
    private float latitudPar;

    @Column(length = 500, nullable = false)
    private String imgPar;



    //Relaciones
    @OneToMany(mappedBy = "paradas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ParadaHasRuta> paradaHasRuta;



    //Constructores
    public Parada() {
    }

    public Parada(Long idPar, String nombrePar, String direccionPar, float longitudPar, float latitudPar, String imgPar) {
        this.idPar = idPar;
        this.nombrePar = nombrePar;
        this.direccionPar = direccionPar;
        this.longitudPar = longitudPar;
        this.latitudPar = latitudPar;
        this.imgPar = imgPar;
    }



    //Getters
    public Long getIdPar() {
        return idPar;
    }

    public String getNombrePar() {
        return nombrePar;
    }

    public String getDireccionPar() {
        return direccionPar;
    }

    public float getLongitudPar() {
        return longitudPar;
    }

    public float getLatitudPar() {
        return latitudPar;
    }

    public String getImgPar() {
        return imgPar;
    }

    public Set<ParadaHasRuta> getParadaHasRuta() {
        return paradaHasRuta;
    }



    //Setters
    public void setIdPar(Long idPar) {
        this.idPar = idPar;
    }

    public void setNombrePar(String nombrePar) {
        this.nombrePar = nombrePar;
    }

    public void setDireccionPar(String direccionPar) {
        this.direccionPar = direccionPar;
    }

    public void setLongitudPar(float longitudPar) {
        this.longitudPar = longitudPar;
    }

    public void setLatitudPar(float latitudPar) {
        this.latitudPar = latitudPar;
    }

    public void setImgPar(String imgPar) {
        this.imgPar = imgPar;
    }

    public void setParadaHasRuta(Set<ParadaHasRuta> paradaHasRuta) {
        this.paradaHasRuta = paradaHasRuta;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Parada{" +
                "idPar=" + idPar +
                ", nombrePar='" + nombrePar + '\'' +
                ", direccionPar='" + direccionPar + '\'' +
                ", longitudPar=" + longitudPar +
                ", latitudPar=" + latitudPar +
                ", imgPar='" + imgPar + '\'' +
                ", paradaHasRuta=" + paradaHasRuta +
                '}';
    }
}
