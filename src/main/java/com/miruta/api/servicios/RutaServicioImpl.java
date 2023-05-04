package com.miruta.api.servicios;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.entidades.UsuarioHasRuta;
import com.miruta.api.interfaces.InRutaDao;
import com.miruta.api.interfaces.InUsuarioHasRutaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public List<Ruta> listarRutasFavoritas(String correoUsuario) {
        List<Long> listaIdRuta = new ArrayList<>();

        for (UsuarioHasRuta usuHasRuta: usuarioHasRutaDao.findAll()) {
            if (usuHasRuta.getUsuarios().getCorreoUsu().equals(correoUsuario)) {
                listaIdRuta.add(usuHasRuta.getRutas().getIdRut());
            }
        }

        System.out.println(listaIdRuta);
        List<Ruta> rutas = rutaDao.findAllById(listaIdRuta);

        return rutas;
    }

}
