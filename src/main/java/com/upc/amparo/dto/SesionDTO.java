package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SesionDTO {
    private Long id;
    private LocalDate fecha;
    private String titulo;
    private String descripcion;
    private String horaInicio;
    private String horaFinal;
    private String linkSesion;
    private String linkGrabacion;
    private Long peticionTrabajador_id;
    private Long historialSesiones_id;
}
