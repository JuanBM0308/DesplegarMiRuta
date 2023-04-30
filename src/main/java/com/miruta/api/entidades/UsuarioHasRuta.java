package com.miruta.api.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usuariosHasRutas")
public class UsuarioHasRuta implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuHasRut;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idUsu", referencedColumnName = "idUsu", nullable = false)
    @JsonIgnore
    private Usuario usuarios;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idRut", referencedColumnName = "idRut", nullable = false)
    @JsonIgnore
    private Ruta rutas;



    //Constructores
    public UsuarioHasRuta() {
    }

    public UsuarioHasRuta(int idUsuHasRut, Usuario usuarios, Ruta rutas) {
        this.idUsuHasRut = idUsuHasRut;
        this.usuarios = usuarios;
        this.rutas = rutas;
    }



    //Getters
    public int getIdUsuHasRut() {
        return idUsuHasRut;
    }

    public Usuario getUsuarios() {
        return usuarios;
    }

    public Ruta getRutas() {
        return rutas;
    }



    //Setters
    public void setIdUsuHasRut(int idUsuHasRut) {
        this.idUsuHasRut = idUsuHasRut;
    }

    public void setUsuarios(Usuario usuarios) {
        this.usuarios = usuarios;
    }

    public void setRutas(Ruta rutas) {
        this.rutas = rutas;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "UsuarioHasRuta{" +
                "idUsuHasRut=" + idUsuHasRut +
                ", usuarios=" + usuarios +
                ", rutas=" + rutas +
                '}';
    }
}
