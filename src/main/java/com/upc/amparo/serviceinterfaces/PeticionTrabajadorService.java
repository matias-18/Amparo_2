package com.upc.amparo.serviceinterfaces;


import com.upc.amparo.dto.PeticionTrabajdorDTO;
import com.upc.amparo.entities.PeticionTrabajador;
import com.upc.amparo.repositories.PeticionTrabajadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PeticionTrabajadorService {
    final PeticionTrabajadorRepository peticionTrabajadorRepository;

    public PeticionTrabajadorService(PeticionTrabajadorRepository peticionTrabajadorRepository) {
        this.peticionTrabajadorRepository = peticionTrabajadorRepository;
    }

    public PeticionTrabajdorDTO create(PeticionTrabajdorDTO peticionTrabajadorDto) {
        ModelMapper modelMapper = new ModelMapper();
        PeticionTrabajador peticionTrabajador = modelMapper.map(peticionTrabajadorDto, PeticionTrabajador.class);
        peticionTrabajadorRepository.save(peticionTrabajador);
        return peticionTrabajadorDto;
    }

    public void delete(Long id) {
        peticionTrabajadorRepository.deleteById(id);
    }

    public PeticionTrabajdorDTO update(Long id, PeticionTrabajdorDTO peticionTrabajadorDto) {
        PeticionTrabajador peticionTrabajador = peticionTrabajadorRepository.findById(id).orElse(null);
        if (peticionTrabajador != null) {
            ModelMapper modelMapper = new ModelMapper();
            peticionTrabajador = modelMapper.map(peticionTrabajadorDto, PeticionTrabajador.class);
            peticionTrabajador.setId(id);
            peticionTrabajadorRepository.save(peticionTrabajador);
            return peticionTrabajadorDto;
        }
        return null;
    }
}