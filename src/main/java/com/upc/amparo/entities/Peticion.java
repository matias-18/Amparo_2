package com.upc.amparo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
public class Peticion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String titulo;
    @NonNull
    private String descripcion;
    @NonNull
    private String tipo;
    @NonNull
    private LocalDate fecha;
    @NonNull
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "victima_id")
    private Victima victima;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "historial_peticiones_id")
    private HistorialPeticiones historialPeticiones;

    @OneToMany(mappedBy = "peticion",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Documento> documentos;

    @OneToMany(mappedBy = "peticion",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PeticionTrabajador> peticionTrabajadores;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Victima getVictima() {
        return victima;
    }

    public void setVictima(Victima victima) {
        this.victima = victima;
    }

    public HistorialPeticiones getHistorialPeticiones() {
        return historialPeticiones;
    }

    public void setHistorialPeticiones(HistorialPeticiones historialPeticiones) {
        this.historialPeticiones = historialPeticiones;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    public List<PeticionTrabajador> getPeticionTrabajadores() {
        return peticionTrabajadores;
    }

    public void setPeticionTrabajadores(List<PeticionTrabajador> peticionTrabajadores) {
        this.peticionTrabajadores = peticionTrabajadores;
    }
}
//Class Request
