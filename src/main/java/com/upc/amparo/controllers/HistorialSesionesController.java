package com.upc.amparo.controllers;

import com.upc.amparo.dto.Historial_SesionesDTO;
import com.upc.amparo.serviceinterfaces.HistorialSesionesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/historial-sesiones")
public class HistorialSesionesController {
    final HistorialSesionesService historialSesionesService;

    public HistorialSesionesController(HistorialSesionesService historialSesionesService) {
        this.historialSesionesService = historialSesionesService;
    }

    @PostMapping("crear_historial-sesiones")
    public Historial_SesionesDTO create(@RequestBody Historial_SesionesDTO historialSesionesDto) {
        return historialSesionesService.create(historialSesionesDto);
    }

    @DeleteMapping("eliminar_historial-sesiones")
    public void delete(@PathVariable Long id) {
        historialSesionesService.delete(id);
    }

    @PutMapping("modificar_historial-sesiones")
    public Historial_SesionesDTO update(@PathVariable Long id, @RequestBody Historial_SesionesDTO historialSesionesDto) {
        return historialSesionesService.update(id, historialSesionesDto);
    }
}

