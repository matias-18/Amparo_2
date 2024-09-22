package com.upc.amparo.repositories;

import com.upc.amparo.entities.PeticionTrabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeticionTrabajadorRepository extends JpaRepository<PeticionTrabajador, Long> {
}