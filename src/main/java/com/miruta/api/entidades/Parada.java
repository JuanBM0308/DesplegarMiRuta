package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private Double longitudPar;

    @Column(nullable = false)
    private Double latitudPar;

    @Column(length = 1000, nullable = false)
    private String imgPar;



    //Relaciones
    @OneToMany(mappedBy = "paradas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ParadaHasRuta> paradaHasRuta;



    //Constructores
    public Parada() {
    }

    public Parada(Long idPar, String nombrePar, String direccionPar, Double longitudPar, Double latitudPar, String imgPar) {
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

    public Double getLongitudPar() {
        return longitudPar;
    }

    public Double getLatitudPar() {
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

    public void setLongitudPar(Double longitudPar) {
        this.longitudPar = longitudPar;
    }

    public void setLatitudPar(Double latitudPar) {
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
