package com.miruta.api.servicios;

import com.miruta.api.entidades.ParadaHasRuta;
import com.miruta.api.interfaces.InParadaHasRutaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miruta.api.interfaces.InParadaDao;
import com.miruta.api.entidades.Parada;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ParadaServicioImpl implements InParadaServicio {

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


    //Metodo guardar parada nueva
    @Override
    public String guardarParada(Parada parada) {
        paradaDao.save(parada);
        return "{'respuesta': 'Parada agregada con exito'}";
    }


    //Metodo eliminar parada
    @Override
    public String eliminarParada(Long idPar) {
        String respuesta = "{'respuesta' : 'Error eliminar parada'}";

        if (paradaDao.existsById(idPar)) {
            paradaDao.deleteById(idPar);
            respuesta = "{'respuesta' : 'Parada eliminada con exito'}";
        }

        return respuesta;
    }


    //Obtener id de las paradas para una ruta
    @Override
    public List<Long> listaIdParadas(Long idRut) {
        List<Long> listaIdParada = new ArrayList<>();

        for (ParadaHasRuta parHasRuta : paradaHasRutaDao.findAll()) {
            if (parHasRuta.getRutas().getIdRut().equals(idRut)) {
                listaIdParada.add(parHasRuta.getParadas().getIdPar());
            }
        }

        return listaIdParada;
    }



    //Actualizacion paradas
    @Override
    public String actualizarParada(Parada NueParada){
        String respuesta = "{'respuesta' : 'No se realizo la actualizacion de la parada'}";

        Parada parada = paradaDao.findById(NueParada.getIdPar())
                .orElseThrow(() -> new NoSuchElementException("la parada #" + NueParada.getIdPar() + " no existe en la base de datos"));

        if(NueParada.getIdPar() != null){
            parada.setNombrePar(NueParada.getNombrePar());
            parada.setDireccionPar(NueParada.getDireccionPar());
            parada.setLatitudPar(NueParada.getLatitudPar());
            parada.setLongitudPar(NueParada.getLongitudPar());
            parada.setImgPar(NueParada.getImgPar());

            paradaDao.save(parada);

            respuesta = "{'respuesta' : 'Se realizo actualizacion de la parada'}";
        }
        return respuesta;
    }


}