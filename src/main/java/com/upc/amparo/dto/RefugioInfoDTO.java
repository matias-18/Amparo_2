package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class RefugioInfoDTO {
    private String nombre;
    private String departamento;
    private String distrito;
    private String direccion;
    private String telefono;
}

//Query refugio
