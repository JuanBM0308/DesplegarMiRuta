package com.miruta.api.interfaces;

import com.miruta.api.entidades.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InBusDao extends JpaRepository<Bus, String> {
}
