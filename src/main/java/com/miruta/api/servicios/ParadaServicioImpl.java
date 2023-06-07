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



    //Metodo listar nombre de las paradas por ruta
    @Override
    public List<String> listarNomParadas_ruta(Long idRut) {
        List<String> listaNomParadas = new ArrayList<>();

        for (Parada parada : paradaDao.findAllById(listaIdParadas(idRut))) {
            listaNomParadas.add(parada.getNombrePar());
        }

        return listaNomParadas;
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



    //Metodo para agregar parada
    public String agregarParada(Parada parada){
        var respuesta = "{'respuesta':'Error al Agregar'}";
        if (!paradaDao.existsById(parada.getIdPar())){
            paradaDao.save(parada);
            respuesta = "{'respuesta':'Agregado correctamente'}";
        }
        return respuesta;
    }



    //Metodo para eliminar parada
    public String eliminarParada(Long idPar) {
        var respuesta = "{'respuesta':'no se pudo eliminar'}";
        if (paradaDao.existsById(idPar)) {
            paradaDao.deleteById(idPar);
            respuesta = "{'respuesta':'eliminado correctamente'}";
        }
        return respuesta;
    }

}