package com.miruta.api.servicios;

import com.miruta.api.entidades.Giro;
import com.miruta.api.interfaces.InGiroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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



    //metodo listar todos los giros existentes
    public List<Giro> listar() {
        return giroDao.findAll();
    }



    //Metodo agregar giro
    public String agregarGiro(Giro giro) {
        var respuesta = "{'respuesta' : 'No se pudo agregar'}";
        if (!giroDao.existsById(giro.getIdGir())){
            giroDao.deleteById(giro.getIdGir());
            respuesta = "{'respuesta' : 'Agregado exitosamente'}";
        }
        return respuesta;
    }



    //Metodo eliminar un giro
    public String eliminarGiro(Long idGir) {
        var respuesta = "{'respuesta' : 'Error eliminar'}";
        if (giroDao.existsById(idGir)){
            giroDao.deleteById(idGir);
            respuesta = "{'respuesta' : 'Eliminado exitosamente'}";
        }
        return respuesta;
    }
}
