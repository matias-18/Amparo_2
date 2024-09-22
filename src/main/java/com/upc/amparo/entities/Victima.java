package com.upc.amparo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Victima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String nombres;
    @NonNull
    private String apellidos;
    @NonNull
    private String email;
    @NonNull
    private String telefono;

    @OneToMany(mappedBy = "victima", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Peticion> peticiones;

    @OneToOne(mappedBy = "victima", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HistorialPeticiones historialPeticiones;

    @OneToOne(mappedBy = "victima", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToOne(mappedBy = "victima", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HistorialSesiones historialSesiones;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Peticion> getPeticiones() {
        return peticiones;
    }

    public void setPeticiones(List<Peticion> peticiones) {
        this.peticiones = peticiones;
    }

    public HistorialPeticiones getHistorialPeticiones() {
        return historialPeticiones;
    }

    public void setHistorialPeticiones(HistorialPeticiones historialPeticiones) {
        this.historialPeticiones = historialPeticiones;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public HistorialSesiones getHistorialSesiones() {
        return historialSesiones;
    }

    public void setHistorialSesiones(HistorialSesiones historialSesiones) {
        this.historialSesiones = historialSesiones;
    }
}
