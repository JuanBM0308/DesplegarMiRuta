package com.miruta.api.modelos;

public class UsuarioHasRutaModelo {

    //Atributos
    private String correoUsu;
    private Long idRut;



    //Constructores
    public UsuarioHasRutaModelo() {
    }

    public UsuarioHasRutaModelo(String correoUsu, Long idRut) {
        this.correoUsu = correoUsu;
        this.idRut = idRut;
    }



    //Getters
    public String getCorreoUsu() {
        return correoUsu;
    }

    public Long getIdRut() {
        return idRut;
    }



    //Setters
    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public void setIdRut(Long idRut) {
        this.idRut = idRut;
    }

}
