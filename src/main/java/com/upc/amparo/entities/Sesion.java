package com.upc.amparo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private LocalDate fecha;
    @NonNull
    private String titulo;
    @NonNull
    private String descripcion;
    @NonNull
    private String horaInicio;
    @NonNull
    private String horaFinal;
    @NonNull
    private String linkSesion;
    @NonNull
    private String linkGrabacion;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "peticion_trabajador_id")
    private PeticionTrabajador peticionTrabajador;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "historial_sesiones_id")
    private HistorialSesiones historialSesiones;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getLinkSesion() {
        return linkSesion;
    }

    public void setLinkSesion(String linkSesion) {
        this.linkSesion = linkSesion;
    }

    public String getLinkGrabacion() {
        return linkGrabacion;
    }

    public void setLinkGrabacion(String linkGrabacion) {
        this.linkGrabacion = linkGrabacion;
    }

    public PeticionTrabajador getPeticionTrabajador() {
        return peticionTrabajador;
    }

    public void setPeticionTrabajador(PeticionTrabajador peticionTrabajador) {
        this.peticionTrabajador = peticionTrabajador;
    }

    public HistorialSesiones getHistorialSesiones() {
        return historialSesiones;
    }

    public void setHistorialSesiones(HistorialSesiones historialSesiones) {
        this.historialSesiones = historialSesiones;
    }
}
