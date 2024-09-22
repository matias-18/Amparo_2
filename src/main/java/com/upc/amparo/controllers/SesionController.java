package com.upc.amparo.controllers;

import com.upc.amparo.dto.SesionDTO;
import com.upc.amparo.dto.SesionInfoDTO;
import com.upc.amparo.serviceinterfaces.SesionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/sesiones")
public class SesionController {
    final SesionService sesionService;

    public SesionController(SesionService sesionService) {
        this.sesionService = sesionService;
    }

    @PostMapping("crear_sesiones")
    public SesionDTO create(@RequestBody SesionDTO sesionDto) {
        return sesionService.create(sesionDto);
    }

    @DeleteMapping("eliminar_sesiones")
    public void delete(@PathVariable Long id) {
        sesionService.delete(id);
    }

    @PutMapping("modificar_sesiones")
    public SesionDTO update(@PathVariable Long id, @RequestBody SesionDTO sesionDto) {
        return sesionService.update(id, sesionDto);
    }

    @GetMapping("buscar_por_fecha")
    public List<SesionInfoDTO> findByFechaBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return sesionService.findByFechaBetween(startDate, endDate);
    }
}
