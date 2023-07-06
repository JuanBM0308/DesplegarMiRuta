package com.miruta.api.servicios;

import com.miruta.api.modelos.UsuarioModeloLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InUsuarioDao;

import java.util.List;
import java.util.NoSuchElementException;
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
                        "\"identifiacion\": "+ usuario.getIdentificacionUsu() + "\n" +
                        "}";
            }
        }

        return respuesta;
    }



    //Metodo buscar usuario por identificacion
    @Override
    public Optional<Usuario> getUsuario(Long identificacionUsu) {
        return usuarioDao.findById(identificacionUsu);
    }



    //Metodo agregar usuario
    @Override
    public String guardarUsuario(Usuario usuario) {
        var respuesta = "{'respuesta' : 'No se pudo eliminar usuario'}";
        if (!usuarioDao.existsById(usuario.getIdentificacionUsu())){
            usuarioDao.save(usuario);
            respuesta = "{'respuesta' : 'Se agrego un usuario'}";
        }
        return respuesta;
    }



    //Metodo eliminar usuario
    @Override
    public String eliminarUsuario(Long idUsu) {
        var respuesta = "{'respuesta' : 'No se pudo eliminar usuario'}";
        if (usuarioDao.existsById(idUsu)){
            usuarioDao.deleteById(idUsu);
            respuesta = "{'respuesta' : 'Eliminado exitosamente'}";
        }
        return respuesta;
    }

    // Metodo actualizar usuario
    @Override
    public String actualizarUsuario(Usuario usu){
        String respuesta = "{'respuesta' : 'No se realizo la actualizacion del usuario'}";

        Usuario usuario = usuarioDao.findById(usu.getIdentificacionUsu())
                .orElseThrow(() -> new NoSuchElementException("El usuario con identificación " + usu.getIdentificacionUsu() + " no existe en la base de datos"));

        if(usuario.getIdentificacionUsu() != null){
            usuario.setCorreoUsu(usu.getCorreoUsu());
            usuario.setContraseniaUsu(usu.getContraseniaUsu());
            usuario.setNombreUsu(usu.getNombreUsu());
            usuario.setFotoUsu(usu.getFotoUsu());

            usuarioDao.save(usuario);

            respuesta = "{'respuesta' : 'Se realizo actualizacion del usuario'}";
        }
        
        return respuesta;
    }
}
