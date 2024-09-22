package com.upc.amparo.repositories;

import com.upc.amparo.entities.Especialidad;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {

    @Query(value = "SELECT e.especialidad_nombre, e.descripcion, e.numero_colegiatura FROM Especialidad e WHERE e.especialidad_nombre = :nombre", nativeQuery = true)
    List<Tuple> findByNombre(String nombre);

}