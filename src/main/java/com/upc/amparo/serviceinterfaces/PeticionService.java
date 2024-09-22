package com.upc.amparo.serviceinterfaces;


import com.upc.amparo.dto.PeticionDTO;
import com.upc.amparo.dto.PeticionInfoDTO;
import com.upc.amparo.entities.Peticion;
import com.upc.amparo.repositories.PeticionRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PeticionService {
    final PeticionRepository peticionRepository;

    public PeticionService(PeticionRepository peticionRepository) {
        this.peticionRepository = peticionRepository;
    }

    public PeticionDTO create(PeticionDTO peticionDto) {
        ModelMapper modelMapper = new ModelMapper();
        Peticion peticion = modelMapper.map(peticionDto, Peticion.class);
        peticionRepository.save(peticion);
        return peticionDto;
    }

    public void delete(Long id) {
        peticionRepository.deleteById(id);
    }

    public PeticionDTO update(Long id, PeticionDTO peticionDto) {
        Peticion peticion = peticionRepository.findById(id).orElse(null);
        if (peticion != null) {
            ModelMapper modelMapper = new ModelMapper();
            peticion = modelMapper.map(peticionDto, Peticion.class);
            peticion.setId(id);
            peticionRepository.save(peticion);
            return peticionDto;
        }
        return null;
    }

    public List<PeticionInfoDTO> findByFecha(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Tuple> tuples = peticionRepository.findByFechaBetween(fechaInicio, fechaFin);
        List<PeticionInfoDTO> peticionesList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            PeticionInfoDTO peticionInfo = new PeticionInfoDTO(
                    tuple.get("titulo", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("tipo", String.class),
                    ((java.sql.Date) tuple.get("fecha")).toLocalDate(), // Conversión a LocalDate
                    tuple.get("estado", String.class)
            );
            peticionesList.add(peticionInfo);
        }
        return peticionesList;
    }

    public List<PeticionInfoDTO> findByTipo(String tipo) {
        List<Tuple> tuples = peticionRepository.findByTipo(tipo);
        List<PeticionInfoDTO> peticionesList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            PeticionInfoDTO peticionInfo = new PeticionInfoDTO(
                    tuple.get("titulo", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("tipo", String.class),
                    ((java.sql.Date) tuple.get("fecha")).toLocalDate(), // Conversión a LocalDate
                    tuple.get("estado", String.class)
            );
            peticionesList.add(peticionInfo);
        }
        return peticionesList;
    }

    public List<PeticionInfoDTO> findByEstado(String estado) {
        List<Tuple> tuples = peticionRepository.findByEstado(estado);
        List<PeticionInfoDTO> peticionesList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            PeticionInfoDTO peticionInfo = new PeticionInfoDTO(
                    tuple.get("titulo", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("tipo", String.class),
                    ((java.sql.Date) tuple.get("fecha")).toLocalDate(), // Conversión a LocalDate
                    tuple.get("estado", String.class)
            );
            peticionesList.add(peticionInfo);
        }
        return peticionesList;
    }
}
