package com.miruta.api.controladores;

import com.miruta.api.entidades.Giro;
import com.miruta.api.servicios.GiroServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/giro")
public class GiroControlador {

    //Objeto para servicio de giro
    @Autowired
    GiroServicioImpl giroServicio;



    //Metodo listar giros por ruta
    @GetMapping("/listarRut/{idRut}")
    public List<Map<String, Object>> listarGiros_rutaCon(@PathVariable("idRut") Long idRut) {
        return giroServicio.listarGiros_ruta(idRut);
    }


    //metodo listar todos los puntos existentes
    @GetMapping("/listar")
    public List<Giro> listarGiro() {
        return giroServicio.listar();
    }



    //Metodo agregar giro
    @PostMapping("/agregar")
    public String agregarGiroCon(@RequestBody Giro giro) {
        return giroServicio.agregarGiro(giro);
    }



    //Metodo eliminar un giro
    @DeleteMapping("/eliminar/{id}")
    public String eliminarGiroCon(@PathVariable("id")Long idGir) {
        return giroServicio.eliminarGiro(idGir);
    }

}
