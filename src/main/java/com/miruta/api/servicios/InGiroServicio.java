package com.miruta.api.servicios;

import com.miruta.api.entidades.Giro;
import java.util.List;
import java.util.Map;

public interface InGiroServicio {

    //Metodo listar giros por ruta
    List<Map<String, Object>> listarGiros_ruta(Long idRut);



    //Metodo listar todos los puntos de giro
    List<Giro> listarGiros();



    //Metodo guardar giro nuevo
    String guardarGiro(Giro giro);



    //Metodo eliminar giro
    String eliminarGiro(Long idGir);

    String actualizarGiro(Giro camgiro);
}
