package com.upc.amparo.controllers;

import com.upc.amparo.dto.VictimaDTO;
import com.upc.amparo.serviceinterfaces.VictimaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/victimas")
public class VictimaController {
    final VictimaService victimaService;

    public VictimaController(VictimaService victimaService) {
        this.victimaService = victimaService;
    }

    @PostMapping("crear_victimas")
    public VictimaDTO create(@RequestBody VictimaDTO victimaDto) {
        return victimaService.create(victimaDto);
    }

    @DeleteMapping("eliminar_victimas")
    public void delete(@PathVariable Long id) {
        victimaService.delete(id);
    }

    @PutMapping("modificar_victimas")
    public VictimaDTO update(@PathVariable Long id, @RequestBody VictimaDTO victimaDto) {
        return victimaService.update(id, victimaDto);
    }
}
