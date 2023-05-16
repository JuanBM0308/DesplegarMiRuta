package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "rutas")
public class Ruta implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRut;

    @Column(length = 45, nullable = false)
    private String lugarInicioRut;

    @Column(length = 45, nullable = false)
    private String lugarDestinoRut;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Time horaInicioRut;

    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Time horaFinalRut;

    @Column(length = 20, nullable = false)
    private String diasDisponiblesRut;



    //Relaciones
    @OneToMany(mappedBy = "rutas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsuarioHasRuta> usuarioHasRuta;

    @OneToMany(mappedBy = "rutas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ParadaHasRuta> paradaHasRuta;

    @OneToMany(mappedBy = "rutas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<BusHasRuta> busHasRuta;

    @OneToMany(mappedBy = "rutas", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<GiroHasRuta> giroHasRuta;



    //Constructores
    public Ruta() {
    }

    public Ruta(Long idRut, String lugarInicioRut, String lugarDestinoRut, Time horaInicioRut, Time horaFinalRut, String diasDisponiblesRut) {
        this.idRut = idRut;
        this.lugarInicioRut = lugarInicioRut;
        this.lugarDestinoRut = lugarDestinoRut;
        this.horaInicioRut = horaInicioRut;
        this.horaFinalRut = horaFinalRut;
        this.diasDisponiblesRut = diasDisponiblesRut;
    }



    //Getters
    public Long getIdRut() {
        return idRut;
    }

    public String getLugarInicioRut() {
        return lugarInicioRut;
    }

    public String getLugarDestinoRut() {
        return lugarDestinoRut;
    }

    public Time getHoraInicioRut() {
        return horaInicioRut;
    }

    public Time getHoraFinalRut() {
        return horaFinalRut;
    }

    public String getDiasDisponiblesRut() {
        return diasDisponiblesRut;
    }

    public Set<UsuarioHasRuta> getUsuarioHasRuta() {
        return usuarioHasRuta;
    }

    public Set<ParadaHasRuta> getParadaHasRuta() {
        return paradaHasRuta;
    }

    public Set<BusHasRuta> getBusHasRuta() {
        return busHasRuta;
    }

    public Set<GiroHasRuta> getGiroHasRuta() {
        return giroHasRuta;
    }



    //Setters
    public void setIdRut(Long idRut) {
        this.idRut = idRut;
    }

    public void setLugarInicioRut(String lugarInicioRut) {
        this.lugarInicioRut = lugarInicioRut;
    }

    public void setLugarDestinoRut(String lugarDestinoRut) {
        this.lugarDestinoRut = lugarDestinoRut;
    }

    public void setHoraInicioRut(Time horaInicioRut) {
        this.horaInicioRut = horaInicioRut;
    }

    public void setHoraFinalRut(Time horaFinalRut) {
        this.horaFinalRut = horaFinalRut;
    }

    public void setDiasDisponiblesRut(String diasDisponiblesRut) {
        this.diasDisponiblesRut = diasDisponiblesRut;
    }

    public void setUsuarioHasRuta(Set<UsuarioHasRuta> usuarioHasRuta) {
        this.usuarioHasRuta = usuarioHasRuta;
    }

    public void setParadaHasRuta(Set<ParadaHasRuta> paradaHasRuta) {
        this.paradaHasRuta = paradaHasRuta;
    }

    public void setBusHasRuta(Set<BusHasRuta> busHasRuta) {
        this.busHasRuta = busHasRuta;
    }

    public void setGiroHasRuta(Set<GiroHasRuta> giroHasRuta) {
        this.giroHasRuta = giroHasRuta;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Ruta{" +
                "idRut=" + idRut +
                ", lugarInicioRut='" + lugarInicioRut + '\'' +
                ", lugarDestinoRut='" + lugarDestinoRut + '\'' +
                ", horaInicioRut=" + horaInicioRut +
                ", horaFinalRut=" + horaFinalRut +
                ", diasDisponiblesRut='" + diasDisponiblesRut + '\'' +
                ", usuarioHasRuta=" + usuarioHasRuta +
                ", paradaHasRuta=" + paradaHasRuta +
                ", busHasRuta=" + busHasRuta +
                ", giroHasRuta=" + giroHasRuta +
                '}';
    }
}