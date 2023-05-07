package com.miruta.api.interfaces;

import com.miruta.api.entidades.UsuarioHasRuta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface InUsuarioHasRutaDao extends JpaRepository<UsuarioHasRuta, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true,
            value = "INSERT INTO " +
                    "usuarios_has_rutas (id_rut, id_usu) " +
                    "VALUES (:idRuta, (SELECT id_usu FROM usuarios WHERE correo_usu = :correoUsu))")
    void agregarRutaFavoritaDao(@Param("idRuta") Long idRuta, @Param("correoUsu") String correoUsu);

}