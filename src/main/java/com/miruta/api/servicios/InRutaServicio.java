package com.miruta.api.servicios;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.modelos.UsuarioHasRutaModelo;
import java.util.List;

public interface InRutaServicio {

    //Metodo listar todas las rutas
    List<Ruta> listarRutas();



    //Metodo guardar ruta nueva
    String guardarRuta(Ruta ruta);



    //Metodo listar rutas favoritas para un usuario con su correo
    List<Ruta> listarRutasFavoritas(String correoUsuario);



    //Metodo agregar rutas favoritas para un usuario
    String agregarRutaFavorita(UsuarioHasRutaModelo usuarioHasRutaModelo);

}
