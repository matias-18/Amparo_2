package com.upc.amparo.repositories;

import com.upc.amparo.entities.HistorialSesiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialSesionesRepository extends JpaRepository<HistorialSesiones, Long> {
}