package com.miruta.api.modelos;

public class UsuarioModeloLogin {

    //Atributos
    private String correoUsu;
    private String contraseniaUsu;



    //Constructores
    public UsuarioModeloLogin() {
    }

    public UsuarioModeloLogin(String correoUsu, String contraseniaUsu) {
        this.correoUsu = correoUsu;
        this.contraseniaUsu = contraseniaUsu;
    }



    //Getters
    public String getCorreoUsu() {
        return correoUsu;
    }

    public String getContraseniaUsu() {
        return contraseniaUsu;
    }



    //Setters
    public void setCorreoUsu(String correoUsu) {
        this.correoUsu = correoUsu;
    }

    public void setContraseniaUsu(String contraseniaUsu) {
        this.contraseniaUsu = contraseniaUsu;
    }
}
