package com.miruta.api.servicios;

import com.miruta.api.entidades.Usuario;
import com.miruta.api.modelos.UsuarioModeloLogin;

import java.util.List;
import java.util.Optional;

public interface InUsuarioServicio {

    //Metodo listar todos los usuarios
    List<Usuario> listarUsuarios();



    //Metodo login usuario
    String loginUsuario(UsuarioModeloLogin usuarioModeloLogin);



    //Metodo buscar usuario por id
    Optional<Usuario> getUsuario(Long idUsu);



    //Metodo comprobar usuario nuevo
    String comprobarUsuario(Usuario usuario);



    //Metodo eliminar usuario
    String eliminarUsuario(Long idUsu);



    //Metodo guardar usuario nuevo
    String guardarUsuario(Usuario usuario);



    //Metodo actualizar usuario
    String actualizarUsuario(Usuario usu);







    //Metodo para encriptar las contraseñas
    String encryptContrasenia(String contraseniaUsu);



    //Metodo para comprobar las contraseñas encriptadas
    Boolean comprobarContrasenia(String contraseniaUsu, String contraseniaEncrypt);
}
