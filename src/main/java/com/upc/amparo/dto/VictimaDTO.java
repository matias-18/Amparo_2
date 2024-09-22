package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class VictimaDTO {
    private Long id;
    private String nombres;
    private String apellidos;
    private String email;
    private Long telefono;
}
