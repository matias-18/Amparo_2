package com.upc.amparo.controllers;


import com.upc.amparo.dto.RolDTO;
import com.upc.amparo.serviceinterfaces.RolService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {
    final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping("crear_roles")
    public RolDTO create(@RequestBody RolDTO rolDto) {
        return rolService.create(rolDto);
    }

    @DeleteMapping("eliminar_roles")
    public void delete(@PathVariable Long id) {
        rolService.delete(id);
    }

    @PutMapping("modificar_roles")
    public RolDTO update(@PathVariable Long id, @RequestBody RolDTO rolDto) {
        return rolService.update(id, rolDto);
    }

}
