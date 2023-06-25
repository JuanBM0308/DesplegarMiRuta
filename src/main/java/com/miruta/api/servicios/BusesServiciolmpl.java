package com.miruta.api.servicios;


import com.miruta.api.entidades.Bus;
import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InBusDao;
import com.miruta.api.interfaces.InUsuarioDao;
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

    //Objeto DAO(Repositorio) de usuario
    @Autowired
    InUsuarioDao usuarioDao;



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
            Usuario usuario = usuarioDao.findById(busModelo.getIdentificacionUsu()).orElse(null);

            if (usuario != null) {
                if (usuario.getTipoUsuario() == 2 && usuario.getBus() == null) {
                    Bus bus = new Bus(
                            busModelo.getPlacaBus(),
                            busModelo.getLongitudBus(),
                            busModelo.getLatitudBus(),
                            usuario
                    );

                    busDao.save(bus);
                    respuesta = "{'respuesta': 'Bus agregado con exito'}";

                } else {
                    respuesta = "{'respuesta': 'Error al Agregar bus/usuario no es conductor o ya tiene asignado un bus'}";
                }

            } else {
                respuesta = "{'respuesta': 'Error al Agregar bus/usuario no existente'}";
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



    //Metodo buscar bus por identificacionUsu
    @Override
    public Optional<Bus> getBus(Long identificacionUsu) {
        Usuario usuario = usuarioDao.findById(identificacionUsu).orElse(null);

        if (usuario != null) {
            return busDao.findByUsuario(usuario);
        }

        return Optional.empty();
    }



    //Metodo actualizar localizacion del bus(longitudBus, latitudBus)
    @Override
    public String actualizarLocalizacionBus(BusModelo busModelo) {
        String respuesta = "{'respuesta': 'Error al actualizar ubicacion bus'}";

        if (busDao.existsById(busModelo.getPlacaBus())){
            Usuario usuario = usuarioDao.findById(busModelo.getIdentificacionUsu()).orElse(null);

            if (usuario != null) {
                if (usuario.getTipoUsuario() == 2 && usuario.getBus() != null) {
                    Bus bus = new Bus(
                            busModelo.getPlacaBus(),
                            busModelo.getLongitudBus(),
                            busModelo.getLatitudBus(),
                            usuario
                    );

                    busDao.save(bus);
                    respuesta = "{'respuesta': 'Localizacion bus actualizada con exito'}";

                } else {
                    respuesta = "{'respuesta': 'Error al actualizar ubicacion bus/usuario no es conductor o no tiene asignado un bus'}";
                }

            } else {
                respuesta = "{'respuesta': 'Error al actualizar ubicacion bus/usuario no existente'}";
            }
        }

        return respuesta;
    }


}
