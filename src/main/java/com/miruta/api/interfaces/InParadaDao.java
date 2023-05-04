package com.miruta.api.interfaces;

import com.miruta.api.entidades.Parada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InParadaDao extends JpaRepository<Parada, Long> {
}
