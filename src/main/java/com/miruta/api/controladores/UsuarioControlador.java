package com.miruta.api.controladores;

import com.miruta.api.entidades.Usuario;

import com.miruta.api.modelos.UsuarioModeloLogin;
import com.miruta.api.servicios.UsuarioServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    //Objeto para servicio de usuario
    @Autowired
    UsuarioServicioImpl usuarioServicio;



    //Metodo listar todos los usuarios
    @GetMapping("/listar")
    public List<Usuario> listarUsuariosCon() {
        return usuarioServicio.listarUsuarios();
    }



    //Metodo login usuario
    @PostMapping("/login")
    public String loginUsuarioCon(@RequestBody UsuarioModeloLogin usuarioModeloLogin) {
        return usuarioServicio.loginUsuario(usuarioModeloLogin);
    }



    //Metodo buscar usuario por id
    @GetMapping("/buscar/{identificacionUsu}")
    public Optional<Usuario> getUsuarioCon(@PathVariable("identificacionUsu") Long identificacionUsu) {
        return usuarioServicio.getUsuario(identificacionUsu);
    }



    //Metodo guardar usuario nuevo
    @PostMapping("/guardar")
    public String guardarUsuarioCon(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }



    //Metodo eliminar usuario
    @DeleteMapping("/eliminar/{identificacionUsu}")
    public String eliminarUsuarioCon(@PathVariable("identificacionUsu") Long identificacionUsu) {
        return usuarioServicio.eliminarUsuario(identificacionUsu);
    }



    //Actualizar usuario
    @PostMapping("/actualizar")
    public String actualizarUsuarioCon(@RequestBody Usuario usu){
        return usuarioServicio.actualizarUsuario(usu);
    }


}
