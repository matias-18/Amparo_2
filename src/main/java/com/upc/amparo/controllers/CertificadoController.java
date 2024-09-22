package com.upc.amparo.controllers;

import com.upc.amparo.dto.CertificadoDTO;
import com.upc.amparo.serviceinterfaces.CertificadoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificados")

public class CertificadoController {
    final CertificadoService certificadoService;


    public CertificadoController(CertificadoService certificadoService) {
        this.certificadoService = certificadoService;
    }

    @PostMapping("crear_certificado")
    public CertificadoDTO create(@RequestBody CertificadoDTO certificadoDto) {
        return certificadoService.create(certificadoDto);
    }

    @DeleteMapping("/eliminar_certificado")
    public void delete(@PathVariable Long id) {
        certificadoService.delete(id);
    }

    @PutMapping("/modificar_certificado")
    public CertificadoDTO update(@PathVariable Long id, @RequestBody CertificadoDTO certificadoDto) {
        return certificadoService.update(id, certificadoDto);
    }
}
