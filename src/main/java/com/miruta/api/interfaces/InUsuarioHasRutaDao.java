package com.miruta.api.interfaces;

import com.miruta.api.entidades.Ruta;
import com.miruta.api.entidades.Usuario;
import com.miruta.api.entidades.UsuarioHasRuta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InUsuarioHasRutaDao extends JpaRepository<UsuarioHasRuta, Long> {

    Optional<UsuarioHasRuta> findByUsuariosAndRutas(Usuario usuarios, Ruta rutas);

}