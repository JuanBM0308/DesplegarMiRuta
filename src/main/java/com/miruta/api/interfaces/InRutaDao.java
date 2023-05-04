package com.miruta.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miruta.api.entidades.Ruta;

public interface InRutaDao extends JpaRepository<Ruta, Long> {
}

































/*Metodo listar todas las rutas con identificacion de si son favoritas para un usuario
    @Query(nativeQuery = true, value = "SELECT r.*, " +

            "CASE " +
                "WHEN uhr.id_usu_has_rut IS NULL THEN 'false' " +
                "ELSE 'true' " +
            "END AS es_favorita " +

            "FROM rutas r " +
            "LEFT JOIN usuarios_has_rutas uhr " +
            "ON r.id_rut = uhr.id_rut " +

            "AND uhr.id_usu = (SELECT id_usu FROM usuarios WHERE correo_usu = ?1)")
    List<Map<String, Object>> listarRutasDao(@Param("correoUsuario") String correoUsuario)*/