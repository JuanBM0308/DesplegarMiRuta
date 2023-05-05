package com.miruta.api.interfaces;

import com.miruta.api.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InUsuarioDao extends JpaRepository<Usuario, Long> {
}
