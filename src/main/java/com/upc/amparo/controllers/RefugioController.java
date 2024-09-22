package com.upc.amparo.controllers;

import com.upc.amparo.dto.RefugioDTO;
import com.upc.amparo.dto.RefugioInfoDTO;
import com.upc.amparo.serviceinterfaces.CertificadoService;
import com.upc.amparo.serviceinterfaces.RefugioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/refugios")
public class RefugioController {

    final RefugioService refugioService;
    public RefugioController(RefugioService refugioService) {
        this.refugioService = refugioService;
    }

    @PostMapping("/crear_refugio")
    public ResponseEntity<RefugioDTO> create(@RequestBody RefugioDTO refugioDto) {
        RefugioDTO createdRefugio = refugioService.create(refugioDto);
        return new ResponseEntity<>(createdRefugio, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar_refugio")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        refugioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/modificar_refugio")
    public ResponseEntity<RefugioDTO> update(@PathVariable Long id, @RequestBody RefugioDTO refugioDto) {
        RefugioDTO updatedRefugio = refugioService.update(id, refugioDto);
        return updatedRefugio != null ?
                new ResponseEntity<>(updatedRefugio, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/busqueda_distrito")
    public ResponseEntity<List<RefugioInfoDTO>> getByDistrito(
            @RequestParam String distrito
    ) {
        return ResponseEntity.ok(refugioService.findByDistrito(distrito));
    }

    @GetMapping("/busqueda_departamento")
    public ResponseEntity<List<RefugioInfoDTO>> getByDepartamento(
            @RequestParam String departamento
    ) {
        return ResponseEntity.ok(refugioService.findByDepartamento(departamento));
    }

}