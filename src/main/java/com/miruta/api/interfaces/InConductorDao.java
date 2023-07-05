package com.miruta.api.interfaces;

import com.miruta.api.entidades.Conductor;
import com.miruta.api.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InConductorDao extends JpaRepository<Conductor, Long> {

    Optional<Conductor> findByUsuario(Usuario usuario);

}
