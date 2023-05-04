package com.miruta.api.servicios;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.entidades.UsuarioHasRuta;
import com.miruta.api.interfaces.InRutaDao;
import com.miruta.api.interfaces.InUsuarioHasRutaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RutaServicioImpl implements InRutaServicio{

    //Objeto DAO(Repositorio) de ruta
    @Autowired
    private InRutaDao rutaDao;

    //Objeto DAO(Repositorio) de ruta
    @Autowired
    private InUsuarioHasRutaDao usuarioHasRutaDao;



    //Metodo listar todas las rutas
    @Override
    public List<Ruta> listarRutas() {
        return rutaDao.findAll();
    }



    //Metodo listar rutas favoritas para un usuario con su correo
    @Override
    public List<Ruta> listarRutasFavoritas() {
        return null;
    }

}
