package com.upc.amparo.controllers;


import com.upc.amparo.dto.TrabajadorDTO;
import com.upc.amparo.serviceinterfaces.TrabajadorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trabajadores")
public class TrabajadorController {
    final TrabajadorService trabajadorService;

    public TrabajadorController(TrabajadorService trabajadorService) {
        this.trabajadorService = trabajadorService;
    }

    @PostMapping("crear_trabajadores")
    public TrabajadorDTO create(@RequestBody TrabajadorDTO trabajadorDto) {
        return trabajadorService.create(trabajadorDto);
    }

    @DeleteMapping("/eliminar_trabajadores/{id}")
    public void delete(@PathVariable Long id) {
        trabajadorService.delete(id);
    }

    // Cambia la ruta para incluir el 'id' como parte del PathVariable
    @PutMapping("/modificar_trabajadores/{id}")
    public TrabajadorDTO update(@PathVariable Long id, @RequestBody TrabajadorDTO trabajadorDto) {
        return trabajadorService.update(id, trabajadorDto);
    }

}
