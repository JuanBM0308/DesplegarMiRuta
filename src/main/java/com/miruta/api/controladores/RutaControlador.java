package com.miruta.api.controladores;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.entidades.UsuarioHasRuta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miruta.api.servicios.RutaServicioImpl;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/ruta")
public class RutaControlador {

    //Objeto para servicio de ruta
    @Autowired
    RutaServicioImpl rutaServicio;



    //Metodo listar todas las rutas
    @GetMapping("/listar")
    public List<Ruta> listarRutasCon() {
        return rutaServicio.listarRutas();
    }



    //Metodo listar rutas favoritas para un usuario con su correo
    @GetMapping("/listarFav/{correo}")
    public List<Ruta> listarRutasFavoritasCon(@PathVariable("correo") String correoUsuario) {
        return rutaServicio.listarRutasFavoritas();
    }
}
