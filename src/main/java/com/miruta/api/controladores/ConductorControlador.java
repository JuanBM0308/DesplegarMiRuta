package com.miruta.api.controladores;

import com.miruta.api.entidades.Conductor;
import com.miruta.api.servicios.ConductorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/conductor")
public class ConductorControlador {

    //Objeto para servicio de conductor
    @Autowired
    ConductorServicioImpl conductorServicio;



    //Metodo para buscar conductor por idUsu
    @GetMapping("/buscar/{idUsu}")
    public Optional<Conductor> getConductorCon(@PathVariable("idUsu") Long idUsu) {
        return conductorServicio.getConductor(idUsu);
    }

}
