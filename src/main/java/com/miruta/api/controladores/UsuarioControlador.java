package com.miruta.api.controladores;

import com.miruta.api.entidades.Usuario;

import com.miruta.api.modelos.UsuarioModeloLogin;
import com.miruta.api.servicios.UsuarioServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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



    //Metodo agregar usuario
    @PostMapping("/agregar")
    public String agregarUsuarioCon(@RequestBody Usuario usuario) {
        return usuarioServicio.agregarUsuario(usuario);
    }




    //Metodo eliminar usuario
    @DeleteMapping("/eliminar/{correoUsu}")
    public String eliminarUsuarioCon(@PathVariable("correoUsu")Long idUsu) {
        return usuarioServicio.eliminarUsuario(idUsu);
    }
}
