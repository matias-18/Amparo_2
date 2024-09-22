package com.upc.amparo.repositories;

import com.upc.amparo.entities.HistorialPeticiones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialPeticionesRepository extends JpaRepository<HistorialPeticiones, Long> {

}
