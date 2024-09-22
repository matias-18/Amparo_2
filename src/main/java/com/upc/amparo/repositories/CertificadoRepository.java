package com.upc.amparo.repositories;

import com.upc.amparo.entities.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository

public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
}