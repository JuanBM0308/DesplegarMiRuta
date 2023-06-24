package com.miruta.api.controladores;

import com.miruta.api.entidades.Bus;
import com.miruta.api.servicios.BusesServiciolmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusControlador {

    //objeto para servicio de bus
    @Autowired
    BusesServiciolmpl busServicio;



    //Metodo listar todos los buses
    @GetMapping("/listar")
    public List<Bus> listarBusCon(){
        return busServicio.listarBus();
    }



    //Metodo guardar bus nuevo
    @PostMapping("/guardar")
    public String guardarBusCon(@RequestBody Bus bus){
        return busServicio.guardarBus(bus);
    }



    //Metodo eliminar bus
    @DeleteMapping("/eliminar/{placaBus}")
    public String eliminarBusCon(@PathVariable("placaBus")String placaBus){
        return busServicio.eliminarBus(placaBus);
    }



    //Metodo buscar bus por identificacionUsu
    @GetMapping("/buscarUsu/{identificacionUsu}")
    public Optional<Bus> getBusCon(@PathVariable("identificacionUsu") Long identificacionUsu) {
        return busServicio.getBus(identificacionUsu);
    }


}
