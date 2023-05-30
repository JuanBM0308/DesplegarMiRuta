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

}
