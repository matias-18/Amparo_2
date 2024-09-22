package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Long especialidad_id;
}




