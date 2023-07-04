package com.miruta.api.servicios;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.modelos.UsuarioHasRutaModelo;
import java.util.List;

public interface InRutaServicio {

    //Metodo listar todas las rutas
    List<Ruta> listarRutas();



    //Metodo guardar ruta nueva
    String guardarRuta(Ruta ruta);



    //Metodo eliminar ruta
    String eliminarRuta(Long idRut);



    //Metodo listar rutas favoritas para un usuario con su correo
    List<Ruta> listarRutasFavoritas(String correoUsuario);



    //Metodo agregar rutas favoritas para un usuario
    String agregarRutaFavorita(UsuarioHasRutaModelo usuarioHasRutaModelo);



    //Metodo eliminar rutas favoritas para un usuario
    String eliminarRutaFavorita(UsuarioHasRutaModelo usuarioHasRutaModelo);



    //Metodo listar todas las rutas que pasan por una parada
    List<Ruta> listarRutas_parada(Long idPar);



    //Metodo listar todas las rutas que tienen asignadas un bus
    List<Ruta> listarRutas_Bus(Long identificacionCon);







    //Obtener id de las rutas favoritas para un usuario con su correo
    List<Long> listaIdRutas(String correoUsuario);

    //Obtener id de las rutas para una parada con su id
    List<Long> listaIdRutas(Long idPar);

    //Obtener id de las rutas para un bus con la placa del bus
    List<Long> listaIdRutasBus(String placaBus);
}
