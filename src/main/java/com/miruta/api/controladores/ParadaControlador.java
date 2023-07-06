package com.miruta.api.controladores;

import com.miruta.api.entidades.Parada;

import com.miruta.api.servicios.ParadaServicioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parada")
public class ParadaControlador {

    //Objeto para servicio de parada
    @Autowired
    ParadaServicioImpl paradaServicio;



    //Metodo listar todas las paradas
    @GetMapping("/listar")
    public List<Parada> listarParadasCon() {
        return paradaServicio.listarParadas();
    }



    //Metodo guardar parada nueva
    @PostMapping("/guardar")
    public String guardarParadaCon(@RequestBody Parada parada){
        return paradaServicio.guardarParada(parada);
    }



    //Metodo eliminar parada
    @DeleteMapping("/eliminar/{idPar}")
    public String eliminarParadaCon(@PathVariable("idPar")Long idPar){
        return paradaServicio.eliminarParada(idPar);
    }



    //Metodo listar paradas por ruta
    @GetMapping("/listarRut/{idRut}")
    public List<Parada> listarParadas_rutaCon(@PathVariable("idRut") Long idRut) {
        return paradaServicio.listarParadas_ruta(idRut);
    }



    //Metodo listar nombre de las paradas por ruta
    @GetMapping("/listarNombreRut/{idRut}")
    public List<String> listarNomParadas_rutaCon(@PathVariable("idRut") Long idRut) {
        return paradaServicio.listarNomParadas_ruta(idRut);
    }



    //Actualizar Parada
    @PutMapping("/actualizar")
    public String actualizarParadaCon(@RequestBody Parada parada){
        return paradaServicio.actualizarParada(parada);
    }



}
