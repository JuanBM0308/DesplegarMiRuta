package com.miruta.api.interfaces;

import com.miruta.api.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InUsuarioDao extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreoUsu(String correoUsu);

}
