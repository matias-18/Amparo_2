package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeticionDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private String tipo;
    private LocalDate fecha;
    private String estado;
    private Long victima_id;
    private Long historial_peticiones_id;
}

