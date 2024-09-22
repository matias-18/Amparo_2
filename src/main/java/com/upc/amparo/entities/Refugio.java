package com.upc.amparo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor

public class Refugio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombre;
    @NonNull
    private String departamento;
    @NonNull
    private String distrito;
    @NonNull
    private String direccion;
    @NonNull
    private String telefono;

    public Refugio(String nombre, String departamento, String distrito, String direccion, String telefono) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.distrito = distrito;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
