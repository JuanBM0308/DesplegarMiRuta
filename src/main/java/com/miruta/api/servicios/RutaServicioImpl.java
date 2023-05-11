package com.miruta.api.servicios;

import com.miruta.api.entidades.ParadaHasRuta;
import com.miruta.api.entidades.Ruta;
import com.miruta.api.entidades.Usuario;
import com.miruta.api.entidades.UsuarioHasRuta;

import com.miruta.api.interfaces.InParadaHasRutaDao;
import com.miruta.api.interfaces.InRutaDao;
import com.miruta.api.interfaces.InUsuarioDao;
import com.miruta.api.interfaces.InUsuarioHasRutaDao;

import com.miruta.api.modelos.UsuarioHasRutaModelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}