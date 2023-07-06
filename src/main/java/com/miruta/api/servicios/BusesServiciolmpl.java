package com.miruta.api.servicios;


import com.miruta.api.entidades.Bus;
import com.miruta.api.entidades.Conductor;
import com.miruta.api.interfaces.InBusDao;
import com.miruta.api.interfaces.InConductorDao;
import com.miruta.api.modelos.BusModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusesServiciolmpl implements InBusServicio {

    //objeto DAO()repositorio de buses
    @Autowired
    InBusDao busDao;

    //Objeto DAO(Repositorio) de conductor
    @Autowired
    InConductorDao conductorDao;



    //Metodo listar todos los buses
    @Override
    public List<Bus> listarBus() {
        return busDao.findAll();
    }



    //Metodo guardar bus nuevo
    @Override
    public String guardarBus(BusModelo busModelo) {
        String respuesta = "{'respuesta': 'Error al Agregar bus'}";

        if (!busDao.existsById(busModelo.getPlacaBus())){
            Conductor conductor = conductorDao.findById(busModelo.getIdentificacionCon()).orElse(null);

            if (conductor != null) {
                if (conductor.getBus() == null) {
                    Bus bus = new Bus(
                            busModelo.getPlacaBus(),
                            busModelo.getLongitudBus(),
                            busModelo.getLatitudBus(),
                            conductor
                    );

                    busDao.save(bus);
                    respuesta = "{'respuesta': 'Bus agregado con exito'}";

                } else {
                    respuesta = "{'respuesta': 'Error al Agregar bus/conductor ya tiene asignado un bus'}";
                }

            } else {
                respuesta = "{'respuesta': 'Error al Agregar bus/conductor no existente'}";
            }
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



    //Metodo buscar bus por identificacionCon
    @Override
    public Optional<Bus> getBus(Long identificacionCon) {
        Conductor conductor = conductorDao.findById(identificacionCon).orElse(null);

        if (conductor != null) {
            return busDao.findByConductor(conductor);
        }

        return Optional.empty();
    }



    //Metodo actualizar localizacion del bus(longitudBus, latitudBus)
    @Override
    public String actualizarLocalizacionBus(BusModelo busModelo) {
        String respuesta = "{'respuesta': 'Error al actualizar ubicacion bus'}";

        if (busDao.existsById(busModelo.getPlacaBus())){
            Conductor conductor = conductorDao.findById(busModelo.getIdentificacionCon()).orElse(null);

            if (conductor != null) {
                if (conductor.getBus() != null) {
                    Bus bus = new Bus(
                            busModelo.getPlacaBus(),
                            busModelo.getLongitudBus(),
                            busModelo.getLatitudBus(),
                            conductor
                    );

                    busDao.save(bus);
                    respuesta = "{'respuesta': 'Localizacion bus actualizada con exito'}";

                } else {
                    respuesta = "{'respuesta': 'Error al actualizar ubicacion bus/conductor no tiene asignado un bus'}";
                }

            } else {
                respuesta = "{'respuesta': 'Error al actualizar ubicacion bus/conductor no existente'}";
            }
        }

        return respuesta;
    }


}
