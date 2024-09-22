package com.upc.amparo.controllers;


import com.upc.amparo.dto.PeticionTrabajdorDTO;
import com.upc.amparo.serviceinterfaces.PeticionTrabajadorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peticion-trabajador")
public class PeticionTrabajadorController {
    final PeticionTrabajadorService peticionTrabajadorService;

    public PeticionTrabajadorController(PeticionTrabajadorService peticionTrabajadorService) {
        this.peticionTrabajadorService = peticionTrabajadorService;
    }

    @PostMapping("crear_peticion-trabajador")
    public PeticionTrabajdorDTO create(@RequestBody PeticionTrabajdorDTO peticionTrabajadorDto) {
        return peticionTrabajadorService.create(peticionTrabajadorDto);
    }

    @DeleteMapping("eliminar_peticion-trabajador/{id}")
    public void delete(@PathVariable Long id) {
        peticionTrabajadorService.delete(id);
    }

    @PutMapping("modificar_peticion-trabajador/{id}")
    public PeticionTrabajdorDTO update(@PathVariable Long id, @RequestBody PeticionTrabajdorDTO peticionTrabajadorDto) {
        return peticionTrabajadorService.update(id, peticionTrabajadorDto);
    }

}
//PericionTrabajadorController