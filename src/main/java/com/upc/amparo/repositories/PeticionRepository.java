package com.upc.amparo.repositories;

import com.upc.amparo.entities.Peticion;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PeticionRepository extends JpaRepository<Peticion, Long> {

    @Query(value = "SELECT p.titulo, p.descripcion, p.tipo, p.fecha, p.estado FROM Peticion p WHERE p.fecha BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Tuple> findByFechaBetween(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT p.titulo, p.descripcion, p.tipo, p.fecha, p.estado FROM Peticion p WHERE p.tipo = :tipo", nativeQuery = true)
    List<Tuple> findByTipo(String tipo);

    @Query(value = "SELECT p.titulo, p.descripcion, p.tipo, p.fecha, p.estado FROM Peticion p WHERE p.estado = :estado", nativeQuery = true)
    List<Tuple> findByEstado(String estado);
}