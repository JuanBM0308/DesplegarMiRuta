package com.miruta.api.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsu;

    @Column(length = 45, nullable = false)
    private String correoUsu;

    @Column(length = 45, nullable = false)
    private String contraseniaUsu;

    @Column(length = 45, nullable = false)
    private String nombreUsu;

    @Column(length = 45, nullable = false)
    private String fotoUsu;



    //Relaciones
    @OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UsuarioHasRuta> usuarioHasRuta;


    //Constructores
    public Usuario() {
    }

    public Usuario(int idUsu, String correoUsu, String contraseniaUsu, String nombreUsu, String fotoUsu) {
        this.idUsu = idUsu;
        this.correoUsu = correoUsu;
        this.contraseniaUsu = contraseniaUsu;
        this.nombreUsu = nombreUsu;
        this.fotoUsu = fotoUsu;
    }



    //Getters
    public int getIdUsu() {
        return idUsu;
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

    public Set<UsuarioHasRuta> getUsuarioHasRuta() {
        return usuarioHasRuta;
    }



    //Setters
    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
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

    public void setUsuarioHasRuta(Set<UsuarioHasRuta> usuarioHasRuta) {
        this.usuarioHasRuta = usuarioHasRuta;
    }



    //Metodo toString
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsu=" + idUsu +
                ", correoUsu='" + correoUsu + '\'' +
                ", contraseniaUsu='" + contraseniaUsu + '\'' +
                ", nombreUsu='" + nombreUsu + '\'' +
                ", fotoUsu='" + fotoUsu + '\'' +
                '}';
    }
}
