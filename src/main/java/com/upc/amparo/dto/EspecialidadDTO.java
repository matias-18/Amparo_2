package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadDTO {
    private Long id;
    private String especialidadNombre;
    private String descripcion;
    private Long numeroColegiatura;
    private Long trabajador_id;
}

