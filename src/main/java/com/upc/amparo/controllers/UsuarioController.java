package com.upc.amparo.controllers;

import com.upc.amparo.dto.UsuarioDTO;
import com.upc.amparo.dto.UsuarioInfoDTO;
import com.upc.amparo.serviceinterfaces.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("crear usuarios")
    public UsuarioDTO create(@RequestBody UsuarioDTO usuarioDto) {
        return usuarioService.create(usuarioDto);
    }

    @DeleteMapping("eliminar_usuarios")
    public void delete(@PathVariable Long id) {
        usuarioService.delete(id);
    }

    @PutMapping("modificar_usuarios")
    public UsuarioDTO update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDto) {
        return usuarioService.update(id, usuarioDto);
    }

    @GetMapping("/buscar_victimas")
    public ResponseEntity<List<UsuarioInfoDTO>> getVictimas() {
        List<UsuarioInfoDTO> victimas = usuarioService.findVictimas();
        return new ResponseEntity<>(victimas, HttpStatus.OK);
    }

    @GetMapping("/buscar_trabajadores")
    public ResponseEntity<List<UsuarioInfoDTO>> getTrabajadores() {
        List<UsuarioInfoDTO> trabajadores = usuarioService.findTrabajadores();
        return new ResponseEntity<>(trabajadores, HttpStatus.OK);
    }

}
