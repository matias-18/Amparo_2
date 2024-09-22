package com.upc.amparo.controllers;


import com.upc.amparo.dto.DocumentoDTO;
import com.upc.amparo.serviceinterfaces.DocumentoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {
    final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping("crear_documento")
    public DocumentoDTO create(@RequestBody DocumentoDTO documentoDto) {
        return documentoService.create(documentoDto);
    }

    @DeleteMapping("eliminar_documento/{id}")
    public void delete(@PathVariable Long id) {
        documentoService.delete(id);
    }

    @PutMapping("/modificar_documento/{id}")
    public DocumentoDTO update(@PathVariable Long id, @RequestBody DocumentoDTO documentoDto) {
        return documentoService.update(id, documentoDto);
    }

}
