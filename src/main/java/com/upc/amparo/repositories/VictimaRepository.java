package com.upc.amparo.repositories;


import com.upc.amparo.entities.Victima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VictimaRepository extends JpaRepository<Victima, Long> {

}