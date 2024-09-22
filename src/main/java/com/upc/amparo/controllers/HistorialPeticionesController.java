package com.upc.amparo.controllers;


import com.upc.amparo.dto.Historial_PeticionesDTO;
import com.upc.amparo.serviceinterfaces.HistorialPeticionesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historial-peticiones")
public class HistorialPeticionesController {
    final HistorialPeticionesService historialPeticionesService;

    public HistorialPeticionesController(HistorialPeticionesService historialPeticionesService) {
        this.historialPeticionesService = historialPeticionesService;
    }

    @PostMapping("crear_historial-peticiones")
    public Historial_PeticionesDTO create(@RequestBody Historial_PeticionesDTO historialPeticionesDto) {
        return historialPeticionesService.create(historialPeticionesDto);
    }

    @DeleteMapping("eliminar_historial-peticiones")
    public void delete(@PathVariable Long id) {
        historialPeticionesService.delete(id);
    }

    @PutMapping("modificar_historial-peticiones")
    public Historial_PeticionesDTO update(@PathVariable Long id, @RequestBody Historial_PeticionesDTO historialPeticionesDto) {
        return historialPeticionesService.update(id, historialPeticionesDto);
    }

}


