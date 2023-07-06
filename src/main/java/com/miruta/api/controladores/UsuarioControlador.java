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
    @GetMapping("/buscar/{idUsu}")
    public Optional<Usuario> getUsuarioCon(@PathVariable("idUsu") Long idUsu) {
        return usuarioServicio.getUsuario(idUsu);
    }



    //Metodo comprobar usuario nuevo
    @PostMapping("/comprobar")
    public String comprobarUsuarioCon(@RequestBody Usuario usuario) {
        return usuarioServicio.comprobarUsuario(usuario);
    }



    //Metodo eliminar usuario
    @DeleteMapping("/eliminar/{idUsu}")
    public String eliminarUsuarioCon(@PathVariable("idUsu") Long idUsu) {
        return usuarioServicio.eliminarUsuario(idUsu);
    }



    //Metodo guardar usuario nuevo
    @PostMapping("/guardar")
    public String guardarUsuarioCon(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }



    //Actualizar usuario
    @PutMapping("/actualizar")
    public String actualizarUsuarioCon(@RequestBody Usuario usu){
        return usuarioServicio.actualizarUsuario(usu);
    }


}
