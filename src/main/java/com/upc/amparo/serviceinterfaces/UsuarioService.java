package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.UsuarioDTO;
import com.upc.amparo.dto.UsuarioInfoDTO;
import com.upc.amparo.entities.Usuario;
import com.upc.amparo.repositories.UsuarioRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioDTO create(UsuarioDTO usuarioDto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);

        if (usuarioDto.getVictima_id() == null) {
            usuario.setVictima(null);
        }

        if (usuarioDto.getTrabajador_id() == null) {
            usuario.setTrabajador(null);
        }

        usuarioRepository.save(usuario);
        return usuarioDto;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UsuarioDTO update(Long id, UsuarioDTO usuarioDto) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            ModelMapper modelMapper = new ModelMapper();
            usuario = modelMapper.map(usuarioDto, Usuario.class);

            if (usuarioDto.getVictima_id() == null) {
                usuario.setVictima(null);
            }

            if (usuarioDto.getTrabajador_id() == null) {
                usuario.setTrabajador(null);
            }

            usuario.setId(id);
            usuarioRepository.save(usuario);
            return usuarioDto;
        }
        return null;
    }

    public List<UsuarioInfoDTO> findVictimas() {
        List<Tuple> tuples = usuarioRepository.findVictimas();
        List<UsuarioInfoDTO> victimasList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            UsuarioInfoDTO victimaInfo = new UsuarioInfoDTO(
                    tuple.get("id", Long.class),
                    tuple.get("nombreUsuario", String.class)
            );
            victimasList.add(victimaInfo);
        }
        return victimasList;
    }

    public List<UsuarioInfoDTO> findTrabajadores() {
        List<Tuple> tuples = usuarioRepository.findTrabajadores();
        List<UsuarioInfoDTO> trabajadoresList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            UsuarioInfoDTO trabajadorInfo = new UsuarioInfoDTO(
                    tuple.get("id", Long.class),
                    tuple.get("nombreUsuario", String.class)
            );
            trabajadoresList.add(trabajadorInfo);
        }
        return trabajadoresList;
    }
}
