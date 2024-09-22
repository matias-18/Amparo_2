package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.Historial_SesionesDTO;
import com.upc.amparo.entities.HistorialSesiones;
import com.upc.amparo.repositories.HistorialSesionesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service

public class HistorialSesionesService {
    final HistorialSesionesRepository historialSesionesRepository;

    public HistorialSesionesService(HistorialSesionesRepository historialSesionesRepository) {
        this.historialSesionesRepository = historialSesionesRepository;
    }

    public Historial_SesionesDTO create(Historial_SesionesDTO historialSesionesDto) {
        ModelMapper modelMapper = new ModelMapper();
        HistorialSesiones historialSesiones = modelMapper.map(historialSesionesDto, HistorialSesiones.class);
        historialSesionesRepository.save(historialSesiones);
        return historialSesionesDto;
    }

    public void delete(Long id) {
        historialSesionesRepository.deleteById(id);
    }

    public Historial_SesionesDTO update(Long id, Historial_SesionesDTO historialSesionesDto) {
        HistorialSesiones historialSesiones = historialSesionesRepository.findById(id).orElse(null);
        if (historialSesiones != null) {
            ModelMapper modelMapper = new ModelMapper();
            historialSesiones = modelMapper.map(historialSesionesDto, HistorialSesiones.class);
            historialSesiones.setId(id);
            historialSesionesRepository.save(historialSesiones);
            return historialSesionesDto;
        }
        return null;
    }
}
