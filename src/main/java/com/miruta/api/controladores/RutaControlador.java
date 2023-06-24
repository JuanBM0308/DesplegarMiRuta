package com.miruta.api.controladores;

import com.miruta.api.modelos.UsuarioHasRutaModelo;

import com.miruta.api.entidades.Ruta;

import com.miruta.api.servicios.RutaServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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



    //Metodo guardar ruta nueva
    @PostMapping("/guardar")
    public String guardarRutaCon(@RequestBody Ruta ruta) {
        return rutaServicio.guardarRuta(ruta);
    }



    //Metodo eliminar ruta
    @DeleteMapping("/eliminar/{idRut}")
    public String eliminarRutaCon(@PathVariable("idRut")Long idRut) {
        return rutaServicio.eliminarRuta(idRut);
    }



    //Obtener id de las rutas favoritas para un usuario con su correo
    @GetMapping("/listaId/{correo}")
    public List<Long> listaIdRutasFavoritas(@PathVariable("correo") String correoUsuario) {
        return rutaServicio.listaIdRutas(correoUsuario);
    }



    //Metodo listar rutas favoritas para un usuario con su correo
    @GetMapping("/listarFav/{correo}")
    public List<Ruta> listarRutasFavoritasCon(@PathVariable("correo") String correoUsuario) {
        return rutaServicio.listarRutasFavoritas(correoUsuario);
    }



    //Metodo agregar rutas favoritas para un usuario
    @PostMapping("/agregarFav")
    public String agregarRutaFavoritaCon(@RequestBody UsuarioHasRutaModelo usuarioHasRutaModelo) {
        return rutaServicio.agregarRutaFavorita(usuarioHasRutaModelo);
    }



    //Metodo eliminar rutas favoritas para un usuario
    @PostMapping("/eliminarFav")
    public String eliminarRutaFavoritaCon(@RequestBody UsuarioHasRutaModelo usuarioHasRutaModelo) {
        return rutaServicio.eliminarRutaFavorita(usuarioHasRutaModelo);
    }



    //Metodo listar todas las rutas que pasan por una parada
    @GetMapping("/listarPar/{idPar}")
    public List<Ruta> listarRutas_paradaCon(@PathVariable("idPar") Long idPar) {
        return rutaServicio.listarRutas_parada(idPar);
    }



    //Metodo listar todas las rutas que tienen asignadas un bus
    @GetMapping("/listarBus/{identificacionUsu}")
    public List<Ruta> listarRutas_BusCon(@PathVariable("identificacionUsu") Long identificacionUsu) {
        return rutaServicio.listarRutas_Bus(identificacionUsu);
    }
}
