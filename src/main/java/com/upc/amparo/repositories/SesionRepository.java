package com.upc.amparo.repositories;

import com.upc.amparo.entities.Sesion;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
    @Query("SELECT s.fecha as fecha, s.titulo as titulo, s.descripcion as descripcion, s.horaInicio as hora_inicio, s.horaFinal as hora_final, s.linkSesion as link_sesion, s.linkGrabacion as link_grabacion FROM Sesion s WHERE s.fecha BETWEEN :startDate AND :endDate")
    List<Tuple> findByFechaBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
