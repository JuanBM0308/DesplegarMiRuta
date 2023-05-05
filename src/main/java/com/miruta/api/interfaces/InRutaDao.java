package com.miruta.api.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miruta.api.entidades.Ruta;

public interface InRutaDao extends JpaRepository<Ruta, Long> {
}