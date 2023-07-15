package com.miruta.api.servicios;

import com.miruta.api.entidades.Parada;
import java.util.List;

public interface InParadaServicio {

    //Metodo listar todas las paradas
    List<Parada> listarParadas();



    //Metodo listar paradas por ruta
    List<Parada> listarParadas_ruta(Long idRut);



    //Metodo listar nombre de las paradas por ruta
    List<String> listarNomParadas_ruta(Long idRut);



    //Metodo guardar parada nueva
    String guardarParada(Parada parada);



    //Metodo eliminar parada
    String eliminarParada(Long idPar);



    //Actualizacion paradas
    String actualizarParada(Parada NueParada);







    //Obtener id de las paradas para una ruta
    List<Long> listaIdParadas(Long idRut);



}
