package com.miruta.api.servicios;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.entidades.UsuarioHasRuta;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface InRutaServicio {

    //Metodo listar todas las rutas
    List<Ruta> listarRutas();



    //Metodo listar rutas favoritas para un usuario con su correo
    List<Ruta> listarRutasFavoritas();

}
