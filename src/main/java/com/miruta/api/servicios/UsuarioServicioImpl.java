package com.miruta.api.servicios;

import com.miruta.api.modelos.UsuarioModeloLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.entidades.Usuario;
import com.miruta.api.interfaces.InUsuarioDao;
import org.springframework.web.bind.annotation.PostMapping;

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



    //Metodo agregar usuario
    public String agregarUsuario(Usuario usuario) {
        var respuesta = "{'respuesta' : 'No se pudo eliminar usuario'}";
        if (!usuarioDao.existsById(usuario.getIdUsu())){
            usuarioDao.save(usuario);
            respuesta = "{'respuesta' : 'Se agrego un usuario'}";
        }
        return respuesta;
    }



    //Metodo eliminar usuario
    public String eliminarUsuario(Long idUsu) {
        var respuesta = "{'respuesta' : 'No se pudo eliminar usuario'}";
        if (usuarioDao.existsById(idUsu)){
            usuarioDao.deleteById(idUsu);
            respuesta = "{'respuesta' : 'Eliminado exitosamente'}";
        }
        return respuesta;
    }

    // Metodo actualizar usuario

    public String actualizarUsuario(Long idUsu,String correo, String contrasena, String nombre, String foto){
        var respuesta = "{'respuesta' : 'No se realizo la actualizacion del usuario'}";

        Usuario usuario = usuarioDao.findById(idUsu).get();

        if(correo != null){
            usuario.setNombreUsu(nombre);
            usuario.setContraseniaUsu(contrasena);
            usuario.setFotoUsu(foto);

            usuarioDao.save(usuario);

            respuesta = "{'respuesta' : 'Se realizo actualizacion del usuario'}";
        }
        
        return respuesta;
    }
}
