package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.VictimaDTO;
import com.upc.amparo.entities.Victima;
import com.upc.amparo.repositories.VictimaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class VictimaService {
    final VictimaRepository victimaRepository;

    public VictimaService(VictimaRepository victimaRepository) {
        this.victimaRepository = victimaRepository;
    }

    public VictimaDTO create(VictimaDTO victimaDto) {
        ModelMapper modelMapper = new ModelMapper();
        Victima victima = modelMapper.map(victimaDto, Victima.class);
        victimaRepository.save(victima);
        return victimaDto;
    }

    public void delete(Long id) {
        victimaRepository.deleteById(id);
    }

    public VictimaDTO update(Long id, VictimaDTO victimaDto) {
        Victima victima = victimaRepository.findById(id).orElse(null);
        if (victima != null) {
            ModelMapper modelMapper = new ModelMapper();
            victima = modelMapper.map(victimaDto, Victima.class);
            victima.setId(id);
            victimaRepository.save(victima);
            return victimaDto;
        }
        return null;
    }
}