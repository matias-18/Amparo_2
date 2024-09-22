package com.upc.amparo.repositories;

import com.upc.amparo.entities.Usuario;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u.id AS id, u.nombre_usuario AS nombreUsuario FROM usuario u WHERE u.trabajador_id IS NULL", nativeQuery = true)
    List<Tuple> findVictimas();

    @Query(value = "SELECT u.id AS id, u.nombre_usuario AS nombreUsuario FROM usuario u WHERE u.victima_id IS NULL", nativeQuery = true)
    List<Tuple> findTrabajadores();
}