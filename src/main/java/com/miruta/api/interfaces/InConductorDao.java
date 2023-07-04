package com.miruta.api.interfaces;

import com.miruta.api.entidades.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InConductorDao extends JpaRepository<Conductor, Long> {
}
