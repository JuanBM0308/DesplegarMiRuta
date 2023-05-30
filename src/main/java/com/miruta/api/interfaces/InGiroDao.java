package com.miruta.api.interfaces;

import com.miruta.api.entidades.Giro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface InGiroDao extends JpaRepository<Giro, Long> {

    @Query(nativeQuery = true,
    value = "SELECT g.*, orden_gir_has_rut FROM giros g LEFT JOIN giros_has_rutas ghr on g.id_gir = ghr.id_gir where ghr.id_rut = ?1")
    List<Map<String, Object>> findGirosByRutaId(Long idRut);

}
