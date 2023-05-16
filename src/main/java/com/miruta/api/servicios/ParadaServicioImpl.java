package com.miruta.api.servicios;

import com.miruta.api.entidades.ParadaHasRuta;
import com.miruta.api.interfaces.InParadaHasRutaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.interfaces.InParadaDao;
import com.miruta.api.entidades.Parada;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParadaServicioImpl implements InParadaServicio{

    //Objeto DAO(Repositorio) de parada
    @Autowired
    InParadaDao paradaDao;

    //Objeto DAO(Repositorio) de paradaHasRuta
    @Autowired
    InParadaHasRutaDao paradaHasRutaDao;



    //Metodo listar todas las paradas
    @Override
    public List<Parada> listarParadas() {
        return paradaDao.findAll();
    }



    //Metodo listar paradas por ruta
    @Override
    public List<Parada> listarParadas_ruta(Long idRut) {
        return paradaDao.findAllById(listaIdParadas(idRut));
    }







    //Obtener id de las paradas para una ruta
    @Override
    public List<Long> listaIdParadas(Long idRut) {
        List<Long> listaIdParada = new ArrayList<>();

        for (ParadaHasRuta parHasRuta: paradaHasRutaDao.findAll()) {
            if (parHasRuta.getRutas().getIdRut().equals(idRut)) {
                listaIdParada.add(parHasRuta.getParadas().getIdPar());
            }
        }

        return listaIdParada;
    }

}