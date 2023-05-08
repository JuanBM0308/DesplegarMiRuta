package com.miruta.api.controladores;

import com.miruta.api.entidades.Usuario;

import com.miruta.api.servicios.UsuarioServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
