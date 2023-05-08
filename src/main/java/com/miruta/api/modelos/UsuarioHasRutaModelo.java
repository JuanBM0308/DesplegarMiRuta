package com.miruta.api.modelos;

public class UsuarioHasRutaModelo {

    //Atributos
    private Long idUsu;
    private Long idRut;



    //Constructores
    public UsuarioHasRutaModelo() {
    }

    public UsuarioHasRutaModelo(Long idUsu, Long idRut) {
        this.idUsu = idUsu;
        this.idRut = idRut;
    }



    //Getters
    public Long getIdUsu() {
        return idUsu;
    }

    public Long getIdRut() {
        return idRut;
    }



    //Setters
    public void setIdUsu(Long idUsu) {
        this.idUsu = idUsu;
    }

    public void setIdRut(Long idRut) {
        this.idRut = idRut;
    }

}
