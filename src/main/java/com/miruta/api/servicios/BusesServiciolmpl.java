package com.miruta.api.servicios;


import com.miruta.api.entidades.Bus;
import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InBusDao;
import com.miruta.api.interfaces.InUsuarioDao;
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



    //Metodo buscar bus por identificacionUsu
    @Override
    public Optional<Bus> getBus(Long identificacionUsu) {
        Usuario usuario = usuarioDao.findById(identificacionUsu).orElse(null);

        if (usuario != null) {
            return busDao.findByUsuario(usuario);
        }

        return Optional.empty();
    }



}
