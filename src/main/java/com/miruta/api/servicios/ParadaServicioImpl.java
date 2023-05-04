package com.miruta.api.servicios;

import com.miruta.api.interfaces.InParadaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.entidades.Parada;
import java.util.List;

@Service
public class ParadaServicioImpl implements InParadaServicio{

    //Objeto DAO(Repositorio) de parada
    @Autowired
    InParadaDao paradaDao;



    //Metodo listar todas las paradas
    @Override
    public List<Parada> listarParadas() {
        return paradaDao.findAll();
    }

}