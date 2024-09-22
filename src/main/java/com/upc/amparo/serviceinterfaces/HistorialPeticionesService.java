package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.Historial_PeticionesDTO;
import com.upc.amparo.entities.HistorialPeticiones;
import com.upc.amparo.repositories.HistorialPeticionesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class HistorialPeticionesService {
    final HistorialPeticionesRepository historialPeticionesRepository;

    public HistorialPeticionesService(HistorialPeticionesRepository historialPeticionesRepository) {
        this.historialPeticionesRepository = historialPeticionesRepository;
    }

    public Historial_PeticionesDTO create(Historial_PeticionesDTO historialPeticionesDto) {
        ModelMapper modelMapper = new ModelMapper();
        HistorialPeticiones historialPeticiones = modelMapper.map(historialPeticionesDto, HistorialPeticiones.class);
        historialPeticionesRepository.save(historialPeticiones);
        return historialPeticionesDto;
    }

    public void delete(Long id) {
        historialPeticionesRepository.deleteById(id);
    }

    public Historial_PeticionesDTO update(Long id, Historial_PeticionesDTO historialPeticionesDto) {
        HistorialPeticiones historialPeticiones = historialPeticionesRepository.findById(id).orElse(null);
        if (historialPeticiones != null) {
            ModelMapper modelMapper = new ModelMapper();
            historialPeticiones = modelMapper.map(historialPeticionesDto, HistorialPeticiones.class);
            historialPeticiones.setId(id);
            historialPeticionesRepository.save(historialPeticiones);
            return historialPeticionesDto;
        }
        return null;
    }
}