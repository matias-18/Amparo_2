package com.upc.amparo.controllers;


import com.upc.amparo.dto.PeticionDTO;
import com.upc.amparo.dto.PeticionInfoDTO;
import com.upc.amparo.serviceinterfaces.PeticionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/peticiones")
public class PeticionController {
    final PeticionService peticionService;

    public PeticionController(PeticionService peticionService) {
        this.peticionService = peticionService;
    }

    @PostMapping("crear_peticiones")
    public PeticionDTO create(@RequestBody PeticionDTO peticionDto) {
        return peticionService.create(peticionDto);
    }

    @DeleteMapping("eliminar_peticiones")
    public void delete(@PathVariable Long id) {
        peticionService.delete(id);
    }

    @PutMapping("modificar_peticiones")
    public PeticionDTO update(@PathVariable Long id, @RequestBody PeticionDTO peticionDto) {
        return peticionService.update(id, peticionDto);
    }

    @GetMapping("buscar_por_fecha")
    public List<PeticionInfoDTO> findByFechaRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return peticionService.findByFecha(startDate, endDate);
    }

    @GetMapping("buscar_por_tipo")
    public List<PeticionInfoDTO> findByTipo(@RequestParam String tipo) {
        return peticionService.findByTipo(tipo);
    }

    @GetMapping("buscar_por_estado")
    public List<PeticionInfoDTO> findByEstado(@RequestParam String estado) {
        return peticionService.findByEstado(estado);
    }
}
