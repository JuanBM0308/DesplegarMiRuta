package com.miruta.api.servicios;

import com.miruta.api.entidades.Conductor;
import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InConductorDao;
import com.miruta.api.interfaces.InUsuarioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ConductorServicioImpl implements InConductorServicio {

    //Objeto DAO(Repositorio) de conductor
    @Autowired
    InConductorDao conductorDao;

    //Objeto DAO(Repositorio) de usuario
    @Autowired
    InUsuarioDao usuarioDao;



    //Metodo para buscar conductor por idUsu
    @Override
    public Optional<Conductor> getConductor(Long idUsu) {
        Usuario usuario = usuarioDao.findById(idUsu).orElse(null);

        if (usuario != null) {
            if (usuario.getTipoUsuario() == 2) {
                return conductorDao.findByUsuario(usuario);
            }
        }

        return Optional.empty();
    }



}
