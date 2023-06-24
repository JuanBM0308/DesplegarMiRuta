package com.miruta.api.servicios;

import com.miruta.api.entidades.Bus;
import java.util.List;
import java.util.Optional;

public interface InBusServicio {

    //Metodo listar todos los buses
    List<Bus> listarBus();



    //Metodo guardar bus nuevo
    String guardarBus(Bus bus);



    //Metodo eliminar bus
    String eliminarBus(String placaBus);



    //Metodo buscar bus por identificacionUsu
    Optional<Bus> getBus(Long identificacionUsu);

}
