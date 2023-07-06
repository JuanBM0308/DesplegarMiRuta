package com.miruta.api.controladores;

import com.miruta.api.entidades.Conductor;
import com.miruta.api.servicios.ConductorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
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
