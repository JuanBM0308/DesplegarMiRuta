package com.miruta.api.interfaces;

import com.miruta.api.entidades.ParadaHasRuta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InParadaHasRutaDao extends JpaRepository<ParadaHasRuta, Long> {
}
