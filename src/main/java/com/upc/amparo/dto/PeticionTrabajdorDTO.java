package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PeticionTrabajdorDTO {
    private Long id;
    private LocalDate fecha;
    private Long trabajador_id;
    private Long peticion_id;
}

