package com.miruta.api.servicios;

import com.miruta.api.modelos.UsuarioModeloLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InUsuarioDao;
import java.util.List;
import java.util.Optional;

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



    //Metodo login usuario
    @Override
    public String loginUsuario(UsuarioModeloLogin usuarioModeloLogin) {
        String respuesta = "{\n" +
                "\"acceso\": false\n" +
                "}";

        Usuario usuario = usuarioDao.findByCorreoUsu(usuarioModeloLogin.getCorreoUsu()).orElse(null);

        if (usuario != null) {
            if (usuario.getContraseniaUsu().equals(usuarioModeloLogin.getContraseniaUsu())) {
                respuesta = "{\n" +
                        "\"acceso\": true,\n" +
                        "\"idUsu\": "+ usuario.getIdUsu() + "\n" +
                        "}";
            }
        }

        return respuesta;
    }



    //Metodo buscar usuario por id
    @Override
    public Optional<Usuario> getUsuario(Long idUsu) {
        return usuarioDao.findById(idUsu);
    }



    //Metodo guardar usuario nuevo
    @Override
    public String guardarUsuario(Usuario usuario) {
        usuarioDao.save(usuario);
        return "{'respuesta': 'Usuario agregado con exito'}";
    }



    //Metodo eliminar usuario
    @Override
    public String eliminarUsuario(Long idUsu) {
        String respuesta = "{'respuesta' : 'Error eliminar usuario'}";

        if (usuarioDao.existsById(idUsu)){
            usuarioDao.deleteById(idUsu);
            respuesta = "{'respuesta' : 'Usuario eliminado con exito'}";
        }

        return respuesta;
    }



}
