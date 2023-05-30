package com.miruta.api.servicios;

import com.miruta.api.entidades.Giro;
import java.util.List;
import java.util.Map;

public interface InGiroServicio {

    //Metodo listar giros por ruta
    List<Map<String, Object>> listarGiros_ruta(Long idRut);

}
