package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.EspecialidadDTO;
import com.upc.amparo.dto.EspecialidadInfoDTO;
import com.upc.amparo.entities.Especialidad;
import com.upc.amparo.repositories.EspecialidadRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadService {
    final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    public EspecialidadDTO create(EspecialidadDTO especialidadDto) {
        ModelMapper modelMapper = new ModelMapper();
        Especialidad especialidad = modelMapper.map(especialidadDto, Especialidad.class);
        especialidadRepository.save(especialidad);
        return especialidadDto;
    }

    public void delete(Long id) {
        especialidadRepository.deleteById(id);
    }

    public EspecialidadDTO update(Long id, EspecialidadDTO especialidadDto) {
        Especialidad especialidad = especialidadRepository.findById(id).orElse(null);
        if (especialidad != null) {
            ModelMapper modelMapper = new ModelMapper();
            especialidad = modelMapper.map(especialidadDto, Especialidad.class);
            especialidad.setId(id);
            especialidadRepository.save(especialidad);
            return especialidadDto;
        }
        return null;
    }

    public List<EspecialidadInfoDTO> findByNombre(String nombre) {
        List<Tuple> tuples = especialidadRepository.findByNombre(nombre);
        List<EspecialidadInfoDTO> especialidadesList = new ArrayList<>();
        for (Tuple tuple : tuples) {
            EspecialidadInfoDTO especialidadInfo = new EspecialidadInfoDTO(
                    tuple.get("especialidad_nombre", String.class),
                    tuple.get("descripcion", String.class),
                    tuple.get("numero_colegiatura", Long.class)
            );
            especialidadesList.add(especialidadInfo);
        }
        return especialidadesList;
    }

}