package com.upc.amparo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Historial_PeticionesDTO {
    private Long id;
    private String descripcion;
    private LocalDate fechaActualizacion;
    private Long victima_id;

}

