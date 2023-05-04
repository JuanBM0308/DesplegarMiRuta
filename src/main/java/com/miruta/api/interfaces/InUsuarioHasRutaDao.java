package com.miruta.api.interfaces;

import com.miruta.api.entidades.UsuarioHasRuta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InUsuarioHasRutaDao extends JpaRepository<UsuarioHasRuta, Long> {
}
