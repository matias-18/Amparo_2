package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SesionInfoDTO {
    private LocalDate fecha;
    private String titulo;
    private String descripcion;
    private String horaInicio;
    private String horaFinal;
    private String linkSesion;
    private String linkGrabacion;
}
//Query: sesión