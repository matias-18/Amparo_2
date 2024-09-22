package com.upc.amparo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioInfoDTO {
    private Long id;
    private String nombreUsuario;
}

//Query: Usuario