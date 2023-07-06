package com.miruta.api.servicios;

import com.miruta.api.entidades.Conductor;

import java.util.Optional;

public interface InConductorServicio {

    //Metodo para buscar conductor por idUsu
    Optional<Conductor> getConductor(Long idUsu);

}
