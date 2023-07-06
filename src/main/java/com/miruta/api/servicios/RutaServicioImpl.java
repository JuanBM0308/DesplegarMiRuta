package com.miruta.api.servicios;

import com.miruta.api.entidades.*;

import com.miruta.api.interfaces.*;

import com.miruta.api.modelos.UsuarioHasRutaModelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RutaServicioImpl implements InRutaServicio{

    //Objeto DAO(Repositorio) de ruta
    @Autowired
    InRutaDao rutaDao;

    //Objeto DAO(Repositorio) de usuarioHasRuta
    @Autowired
    InUsuarioHasRutaDao usuarioHasRutaDao;

    //Objeto DAO(Repositorio) de usuario
    @Autowired
    InUsuarioDao usuarioDao;

    //Objeto DAO(Repositorio) de paradaHasRuta
    @Autowired
    InParadaHasRutaDao paradaHasRutaDao;

    //Objeto DAO(Repositorio) de bus
    @Autowired
    InBusDao busDao;

    //Objeto DAO(Repositorio) de BusHasRuta
    @Autowired
    InBusHasRutaDao busHasRutaDao;

    //Objeto DAO(Repositorio) de Conductor
    @Autowired
    InConductorDao conductorDao;



    //Metodo listar todas las rutas
    @Override
    public List<Ruta> listarRutas() {
        return rutaDao.findAll();
    }



    //Metodo guardar ruta nueva
    @Override
    public String guardarRuta(Ruta ruta) {
        rutaDao.save(ruta);
        return "{'respuesta': 'Ruta agregada con exito'}";
    }



    //Metodo eliminar ruta
    @Override
    public String eliminarRuta(Long idRut) {
        String respuesta = "{'respuesta' : 'Error eliminar ruta'}";

        if (rutaDao.existsById(idRut)){
            rutaDao.deleteById(idRut);
            respuesta = "{'respuesta' : 'Ruta eliminada con exito'}";
        }

        return respuesta;
    }



    //Metodo listar rutas favoritas para un usuario con su correo
    @Override
    public List<Ruta> listarRutasFavoritas(String correoUsuario) {
        return rutaDao.findAllById(listaIdRutas(correoUsuario));
    }



    //Metodo agregar rutas favoritas para un usuario
    @Override
    public String agregarRutaFavorita(UsuarioHasRutaModelo usuarioHasRutaModelo) {
        String respuesta = "{'respuesta': 'No se agrego a favoritos'}";

        UsuarioHasRuta usuarioHasRuta = new UsuarioHasRuta();
        Usuario usuario = usuarioDao.findByCorreoUsu(usuarioHasRutaModelo.getCorreoUsu()).orElse(null);
        Ruta ruta = rutaDao.findById(usuarioHasRutaModelo.getIdRut()).orElse(null);

        if (usuario != null && ruta != null) {
            usuarioHasRuta.setUsuarios(usuario);
            usuarioHasRuta.setRutas(ruta);
            usuarioHasRutaDao.save(usuarioHasRuta);
            respuesta = "{'respuesta': 'Agregada a favoritos'}";
        }

        return respuesta;
    }



    //Metodo eliminar rutas favoritas para un usuario
    @Override
    public String eliminarRutaFavorita(UsuarioHasRutaModelo usuarioHasRutaModelo) {
        String respuesta = "{'respuesta': 'No se elimino de favoritos'}";

        Usuario usuario = usuarioDao.findByCorreoUsu(usuarioHasRutaModelo.getCorreoUsu()).orElse(null);
        Ruta ruta = rutaDao.findById(usuarioHasRutaModelo.getIdRut()).orElse(null);

        if (usuario != null && ruta != null) {
            UsuarioHasRuta usuarioHasRuta = usuarioHasRutaDao.findByUsuariosAndRutas(usuario, ruta).orElse(null);

            if (usuarioHasRuta != null) {
                usuarioHasRutaDao.delete(usuarioHasRuta);
                respuesta = "{'respuesta': 'Eliminada de favoritos'}";
            }
        }

        return respuesta;
    }



    //Metodo listar todas las rutas que pasan por una parada
    @Override
    public List<Ruta> listarRutas_parada(Long idPar) {
        return rutaDao.findAllById(listaIdRutas(idPar));
    }



    //Metodo listar todas las rutas que tienen asignadas un bus
    @Override
    public List<Ruta> listarRutas_Bus(Long identificacionCon) {
        Conductor conductor = conductorDao.findById(identificacionCon).orElse(null);

        if (conductor != null) {
            Bus bus = busDao.findByConductor(conductor).orElse(null);
            if (bus != null) {
                return rutaDao.findAllById(listaIdRutasBus(bus.getPlacaBus()));
            }
        }

        return new ArrayList<>();
    }



    //Metodo actualizar ruta
    @Override
    public String actualizarRuta(Ruta NueRuta){
        String respuesta = "{'respuesta' : 'No se realizo la actualizacion de la ruta'}";

        Ruta ruta = rutaDao.findById(NueRuta.getIdRut())
                .orElseThrow(() -> new NoSuchElementException("la parada #" + NueRuta.getIdRut() + " no existe en la base de datos"));

        if(NueRuta.getIdRut() != null){
            ruta.setLugarInicioRut(NueRuta.getLugarInicioRut());
            ruta.setLugarDestinoRut(NueRuta.getLugarDestinoRut());
            ruta.setHoraInicioRut(NueRuta.getHoraInicioRut());
            ruta.setHoraFinalRut(NueRuta.getHoraFinalRut());
            ruta.setDiasDisponiblesRut(NueRuta.getDiasDisponiblesRut());

            rutaDao.save(ruta);

            respuesta = "{'respuesta' : 'Se realizo actualizacion de la ruta'}";
        }
        return respuesta;
    }







    //Obtener id de las rutas favoritas para un usuario con su correo
    @Override
    public List<Long> listaIdRutas(String correoUsuario) {
        List<Long> listaIdRuta = new ArrayList<>();

        for (UsuarioHasRuta usuHasRuta: usuarioHasRutaDao.findAll()) {
            if (usuHasRuta.getUsuarios().getCorreoUsu().equals(correoUsuario)) {
                listaIdRuta.add(usuHasRuta.getRutas().getIdRut());
            }
        }

        return listaIdRuta;
    }

    //Obtener id de las rutas para una parada con su id
    @Override
    public List<Long> listaIdRutas(Long idPar) {
        List<Long> listaIdRuta = new ArrayList<>();

        for (ParadaHasRuta parHasRuta: paradaHasRutaDao.findAll()) {
            if (parHasRuta.getParadas().getIdPar().equals(idPar)) {
                listaIdRuta.add(parHasRuta.getRutas().getIdRut());
            }
        }

        return listaIdRuta;
    }

    //Obtener id de las rutas para un bus con la placa del bus
    @Override
    public List<Long> listaIdRutasBus(String placaBus) {
        List<Long> listaIdRuta = new ArrayList<>();

        for (BusHasRuta busHasRuta: busHasRutaDao.findAll()) {
            if (busHasRuta.getBuses().getPlacaBus().equals(placaBus)) {
                listaIdRuta.add(busHasRuta.getRutas().getIdRut());
            }
        }

        return listaIdRuta;
    }



}