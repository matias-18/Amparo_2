package com.upc.amparo.serviceinterfaces;


import com.upc.amparo.dto.RolDTO;
import com.upc.amparo.entities.Rol;
import com.upc.amparo.repositories.RolRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolService {
    final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public RolDTO create(RolDTO rolDto) {
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = modelMapper.map(rolDto, Rol.class);
        rolRepository.save(rol);
        return rolDto;
    }

    public void delete(Long id) {
        rolRepository.deleteById(id);
    }

    public RolDTO update(Long id, RolDTO rolDto) {
        Rol rol = rolRepository.findById(id).orElse(null);
        if (rol != null) {
            ModelMapper modelMapper = new ModelMapper();
            rol = modelMapper.map(rolDto, Rol.class);
            rol.setId(id);
            rolRepository.save(rol);
            return rolDto;
        }
        return null;
    }


}