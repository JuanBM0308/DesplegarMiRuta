package com.miruta.api.controladores;

import com.miruta.api.entidades.Giro;
import com.miruta.api.servicios.GiroServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/giro")
public class GiroControlador {

    //Objeto para servicio de giro
    @Autowired
    GiroServicioImpl giroServicio;



    //Metodo listar giros por ruta
    @GetMapping("listarRut/{idRut}")
    public List<Map<String, Object>> listarGiros_rutaCon(@PathVariable("idRut") Long idRut) {
        return giroServicio.listarGiros_ruta(idRut);
    }

}
