package com.miruta.api.controladores;

import com.miruta.api.entidades.Bus;
import com.miruta.api.servicios.BusesServiciolmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusControlador {

    //objeto para servicio de bus
    @Autowired
    BusesServiciolmpl BusServicio;



    //Metodo listar todos los buses
    @GetMapping("/listar")
    public List<Bus> ListarBusCon(){
        return BusServicio.listarBus();
    }



    //Metodo agregar Bus
    @PostMapping("/agregar")
    public String AgregarBusCon(@RequestBody Bus bus){
        return BusServicio.agregarBus(bus);
    }



    //Metodo eliminar bus
    @DeleteMapping("/eliminar/{placa}")
    public String EliminarBusCon(@PathVariable("placa")String placaBus){
        return BusServicio.eliminarBus(placaBus);
    }
}
