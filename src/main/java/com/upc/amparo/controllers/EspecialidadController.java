package com.upc.amparo.controllers;


import com.upc.amparo.dto.EspecialidadDTO;
import com.upc.amparo.dto.EspecialidadInfoDTO;
import com.upc.amparo.serviceinterfaces.EspecialidadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
    final EspecialidadService especialidadService;

    public EspecialidadController(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("crear_especialidad")
    public EspecialidadDTO create(@RequestBody EspecialidadDTO especialidadDto) {
        return especialidadService.create(especialidadDto);
    }

    @DeleteMapping("eliminar_especialidad")
    public void delete(@PathVariable Long id) {
        especialidadService.delete(id);
    }

    @PutMapping("modificar_especialidad")
    public EspecialidadDTO update(@PathVariable Long id, @RequestBody EspecialidadDTO especialidadDto) {
        return especialidadService.update(id, especialidadDto);
    }

    @GetMapping("buscar_por_nombre_especialidad")
    public List<EspecialidadInfoDTO> findByNombre(@RequestParam String nombre) {
        return especialidadService.findByNombre(nombre);
    }
}
