package com.miruta.api.servicios;

import com.miruta.api.entidades.Giro;
import com.miruta.api.interfaces.InGiroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class GiroServicioImpl implements InGiroServicio {

    //Objeto DAO(Repositorio) de parada
    @Autowired
    InGiroDao giroDao;



    //Metodo listar giros por ruta
    @Override
    public List<Map<String, Object>> listarGiros_ruta(Long idRut) {
        return giroDao.findGirosByRutaId(idRut);
    }



    //Metodo listar todos los puntos de giro
    @Override
    public List<Giro> listarGiros() {
        return giroDao.findAll();
    }



    //Metodo guardar giro nuevo
    @Override
    public String guardarGiro(Giro giro) {
        giroDao.save(giro);
        return "{'respuesta': 'Giro agregado con exito'}";
    }



    //Metodo eliminar giro
    @Override
    public String eliminarGiro(Long idGir) {
        String respuesta = "{'respuesta' : 'Error eliminar giro'}";

        if (giroDao.existsById(idGir)){
            giroDao.deleteById(idGir);
            respuesta = "{'respuesta' : 'Giro eliminado con exito'}";
        }

        return respuesta;
    }

    //Metodo actualizar GIRO
    @Override
    public String actualizarGiro(Giro camgiro){
        String respuesta = "{'respuesta' : 'No se realizo la actualizacion del Punto de giro'}";

        Giro giro = giroDao.findById(camgiro.getIdGir())
                .orElseThrow(() -> new NoSuchElementException("El punto de giro #" + camgiro.getIdGir() + " no existe en la base de datos"));

        if(camgiro.getIdGir() != null){
            giro.setLatitudGir(giro.getLatitudGir());
            giro.setLongitudGir(giro.getLongitudGir());

            giroDao.save(giro);

            respuesta = "{'respuesta' : 'Se realizo actualizacion del Punto de giro'}";
        }

        return respuesta;
    }
}
