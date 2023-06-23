package com.miruta.api.entidades;

import jakarta.persistence.*;
import org.hibernate.Length;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    //Atributos
    @Id
    private Long identificacionUsu;

    @Column(length = 45, nullable = false)
    private String correoUsu;

    @Column(length = 45, nullable = false)
    private String contraseniaUsu;

    @Column(length = 45, nullable = false)
    private String nombreUsu;

    @Column(length = 45, nullable = false)
    private String fotoUsu;

    @Column(length = 2, nullable = false)
    private Integer tipoUsuario;



    //Relaciones
    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsuarioHasRuta> usuarioHasRuta;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bus bus;



    //Constructores
    public Usuario() {
    }

    public Usuario(Long identificacionUsu, String correoUsu, String contraseniaUsu, String nombreUsu, String fotoUsu, Integer tipoUsuario) {
        this.identificacionUsu = identificacionUsu;
        this.correoUsu = correoUsu;
        this.contraseniaUsu = contraseniaUsu;
        this.nombreUsu = nombreUsu;
        this.fotoUsu = fotoUsu;
        this.tipoUsuario = tipoUsuario;
    }



    //Getters
    public Long getIdentificacionUsu() {
        return identificacionUsu;
    }

    public String getCorreoUsu() {
        return correoUsu;
    }

    public String getContraseniaUsu() {
        return contraseniaUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public String getFotoUsu() {
        return fotoUsu;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public Set<UsuarioHasRuta> getUsuarioHasRuta() {
        return usuarioHasRuta;
    }

    public Bus getBus() {
        return bus;
    }



    //Setters
    public void setIdentificacionUsu(Long identificacionUsu) {
        this.identificacionUsu = identificacionUsu;
    }

    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public void setContraseniaUsu(String contraseniaUsu) {
        this.contraseniaUsu = contraseniaUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public void setFotoUsu(String fotoUsu) {
        this.fotoUsu = fotoUsu;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setUsuarioHasRuta(Set<UsuarioHasRuta> usuarioHasRuta) {
        this.usuarioHasRuta = usuarioHasRuta;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Usuario{" +
                "identificacionUsu=" + identificacionUsu +
                ", correoUsu='" + correoUsu + '\'' +
                ", contraseniaUsu='" + contraseniaUsu + '\'' +
                ", nombreUsu='" + nombreUsu + '\'' +
                ", fotoUsu='" + fotoUsu + '\'' +
                ", tipoUsuario=" + tipoUsuario +
                ", usuarioHasRuta=" + usuarioHasRuta +
                ", bus=" + bus +
                '}';
    }


}
