package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EspecialidadInfoDTO {
    private String especialidad_nombre;
    private String descripcion;
    private Long numero_colegiatura;
}

