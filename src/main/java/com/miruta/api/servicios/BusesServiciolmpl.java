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

    
    //metodo agregar bus
    public String agregarBus(Bus bus) {
        var respuesta = "{'respuesta':'Error al Agregar'}";
        if (!busDao.existsById(bus.getPlacaBus())){
            busDao.save(bus);
            respuesta = "{'respuesta':'Agregado correctamente'}";
        }
        return respuesta;
    }

    public String eliminarBus(String placaBus) {
        var respuesta = "{'respuesta' : 'Error eliminar'}";
        if (busDao.existsById(placaBus)){
            busDao.deleteById(placaBus);
            return respuesta = "{'respuesta':'Eliminado correctamente'}";
        }
        return respuesta;
    }
}
