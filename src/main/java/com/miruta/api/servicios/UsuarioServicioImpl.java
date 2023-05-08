package com.miruta.api.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InUsuarioDao;
import java.util.List;

@Service
public class UsuarioServicioImpl implements InUsuarioServicio{

    //Objeto DAO(Repositorio) de usuario
    @Autowired
    InUsuarioDao usuarioDao;



    //Metodo listar todos los usuarios
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }

}
