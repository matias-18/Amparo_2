package com.upc.amparo.serviceinterfaces;


import com.upc.amparo.dto.TrabajadorDTO;
import com.upc.amparo.entities.Trabajador;
import com.upc.amparo.repositories.TrabajadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorService {
    final TrabajadorRepository trabajadorRepository;

    public TrabajadorService(TrabajadorRepository trabajadorRepository) {
        this.trabajadorRepository = trabajadorRepository;
    }

    public TrabajadorDTO create(TrabajadorDTO trabajadorDto) {
        ModelMapper modelMapper = new ModelMapper();
        Trabajador trabajador = modelMapper.map(trabajadorDto, Trabajador.class);
        trabajadorRepository.save(trabajador);
        return trabajadorDto;
    }

    public void delete(Long id) {
        trabajadorRepository.deleteById(id);
    }

    public TrabajadorDTO update(Long id, TrabajadorDTO trabajadorDto) {
        Trabajador trabajador = trabajadorRepository.findById(id).orElse(null);
        if (trabajador != null) {
            ModelMapper modelMapper = new ModelMapper();
            trabajador = modelMapper.map(trabajadorDto, Trabajador.class);
            trabajador.setId(id);
            trabajadorRepository.save(trabajador);
            return trabajadorDto;
        }
        return null;
    }
}