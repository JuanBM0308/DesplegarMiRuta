package com.miruta.api.servicios;


import com.miruta.api.entidades.Bus;
import com.miruta.api.interfaces.InBusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusesServiciolmpl implements InBusServicio {

    //objeto DAO()repositorio de buses
    @Autowired
    InBusDao busDao;



    //Metodo listar todos los buses
    @Override
    public List<Bus> listarBus() {
        return busDao.findAll();
    }



    //Metodo guardar bus nuevo
    @Override
    public String guardarBus(Bus bus) {
        String respuesta = "{'respuesta': 'Error al Agregar bus'}";

        if (!busDao.existsById(bus.getPlacaBus())){
            busDao.save(bus);
            respuesta = "{'respuesta': 'Bus agregado con exito'}";
        }

        return respuesta;
    }



    //Metodo eliminar bus
    @Override
    public String eliminarBus(String placaBus) {
        String respuesta = "{'respuesta' : 'Error eliminar bus'}";

        if (busDao.existsById(placaBus)){
            busDao.deleteById(placaBus);
            respuesta = "{'respuesta':'Bus eliminado con exito'}";
        }

        return respuesta;
    }



}
