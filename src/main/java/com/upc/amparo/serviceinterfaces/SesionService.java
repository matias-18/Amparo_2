package com.upc.amparo.serviceinterfaces;


import com.upc.amparo.dto.SesionDTO;
import com.upc.amparo.dto.SesionInfoDTO;
import com.upc.amparo.entities.Sesion;
import com.upc.amparo.repositories.SesionRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SesionService {
    final SesionRepository sesionRepository;

    public SesionService(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    public SesionDTO create(SesionDTO sesionDto) {
        ModelMapper modelMapper = new ModelMapper();
        Sesion sesion = modelMapper.map(sesionDto, Sesion.class);
        sesionRepository.save(sesion);
        return sesionDto;
    }

    public void delete(Long id) {
        sesionRepository.deleteById(id);
    }

    public SesionDTO update(Long id, SesionDTO sesionDto) {
        Sesion sesion = sesionRepository.findById(id).orElse(null);
        if (sesion != null) {
            ModelMapper modelMapper = new ModelMapper();
            sesion = modelMapper.map(sesionDto, Sesion.class);
            sesion.setId(id);
            sesionRepository.save(sesion);
            return sesionDto;
        }
        return null;
    }

    public List<SesionInfoDTO> findByFechaBetween(LocalDate startDate, LocalDate endDate) {
        List<Tuple> tuples = sesionRepository.findByFechaBetween(startDate, endDate);
        List<SesionInfoDTO> sesionesList = new ArrayList<>();

        for (Tuple tuple : tuples) {
            SesionInfoDTO sesionInfo = new SesionInfoDTO(
                    tuple.get("fecha", LocalDate.class),
                    tuple.get("titulo", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("hora_inicio", String.class),
                    tuple.get("hora_final", String.class),
                    tuple.get("link_sesion", String.class),
                    tuple.get("link_grabacion", String.class)
            );
            sesionesList.add(sesionInfo);
        }

        return sesionesList;
    }



}