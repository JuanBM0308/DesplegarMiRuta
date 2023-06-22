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



    //Metodo listar todos los puntos de giro
    @GetMapping("/listar")
    public List<Giro> listarGirosCon() {
        return giroServicio.listarGiros();
    }



    //Metodo guardar giro nuevo
    @PostMapping("/guardar")
    public String guardarGiroCon(@RequestBody Giro giro) {
        return giroServicio.guardarGiro(giro);
    }



    //Metodo eliminar un giro
    @DeleteMapping("/eliminar/{idGir}")
    public String eliminarGiroCon(@PathVariable("idGir")Long idGir) {
        return giroServicio.eliminarGiro(idGir);
    }

}
