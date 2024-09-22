package com.upc.amparo.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Trabajador {
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
    private int telefono;

    @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "trabajador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PeticionTrabajador> peticionesTrabajador;

    @OneToOne(mappedBy = "trabajador", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Usuario usuario;


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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public List<PeticionTrabajador> getPeticionesTrabajador() {
        return peticionesTrabajador;
    }

    public void setPeticionesTrabajador(List<PeticionTrabajador> peticionesTrabajador) {
        this.peticionesTrabajador = peticionesTrabajador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
