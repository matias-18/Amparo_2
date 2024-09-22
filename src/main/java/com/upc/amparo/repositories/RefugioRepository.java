package com.upc.amparo.repositories;

import com.upc.amparo.entities.Refugio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.persistence.Tuple;

import java.util.List;

@Repository

public interface RefugioRepository extends JpaRepository<Refugio, Long> {
    @Query(value = "SELECT r.nombre AS nombre, r.departamento AS departamento, r.distrito AS distrito, r.direccion AS direccion, r.telefono AS telefono FROM refugio r WHERE r.distrito = :distrito", nativeQuery = true)
    List<Tuple> findByDistrito(@Param("distrito") String distrito);

    @Query(value = "SELECT r.nombre AS nombre, r.departamento AS departamento, r.distrito AS distrito, r.direccion AS direccion, r.telefono AS telefono FROM refugio r WHERE r.departamento = :departamento", nativeQuery = true)
    List<Tuple> findByDepartamento(@Param("departamento") String departamento);



}
