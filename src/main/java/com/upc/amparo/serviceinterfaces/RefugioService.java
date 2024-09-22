package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.RefugioDTO;
import com.upc.amparo.dto.RefugioInfoDTO;
import com.upc.amparo.entities.Refugio;
import com.upc.amparo.repositories.RefugioRepository;
import jakarta.persistence.Tuple;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class RefugioService {
    final RefugioRepository refugioRepository;

    public RefugioService(RefugioRepository refugioRepository) {
        this.refugioRepository = refugioRepository;
    }

    public RefugioDTO create(RefugioDTO refugioDto) {
        ModelMapper modelMapper = new ModelMapper();
        Refugio refugio = modelMapper.map(refugioDto, Refugio.class);
        refugioRepository.save(refugio);
        return refugioDto;
    }

    public void delete(Long id) {
        refugioRepository.deleteById(id);
    }

    public RefugioDTO update(Long id, RefugioDTO refugioDto) {
        Refugio refugio = refugioRepository.findById(id).orElse(null);
        if (refugio != null) {
            ModelMapper modelMapper = new ModelMapper();
            refugio = modelMapper.map(refugioDto, Refugio.class);
            refugio.setId(id);
            refugioRepository.save(refugio);
            return refugioDto;
        }
        return null;
    }

    public List<RefugioInfoDTO> findByDistrito(String distrito) {
        List<Tuple> tuplas = refugioRepository.findByDistrito(distrito);
        List<RefugioInfoDTO> listaRefugios = new ArrayList<>();
        for (Tuple tuple : tuplas) {
            RefugioInfoDTO refugioInfo = new RefugioInfoDTO(
                    tuple.get("nombre", String.class),     // Cambia a "nombre"
                    tuple.get("departamento", String.class), // Asegúrate de que "departamento" esté en tu consulta
                    tuple.get("distrito", String.class),     // Asegúrate de que "distrito" esté en tu consulta
                    tuple.get("direccion", String.class),     // Asegúrate de que "direccion" esté en tu consulta
                    tuple.get("telefono", String.class)       // Asegúrate de que "telefono" esté en tu consulta
            );
            listaRefugios.add(refugioInfo);
        }
        return listaRefugios;
    }

    public List<RefugioInfoDTO> findByDepartamento(String departamento) {
        List<Tuple> tuplas = refugioRepository.findByDepartamento(departamento);
        List<RefugioInfoDTO> listaRefugios = new ArrayList<>();
        for (Tuple tuple : tuplas) {
            RefugioInfoDTO refugioInfo = new RefugioInfoDTO(
                    tuple.get("nombre", String.class),      // Cambia a "nombre"
                    tuple.get("departamento", String.class), // Asegúrate de que "departamento" esté en tu consulta
                    tuple.get("distrito", String.class),     // Asegúrate de que "distrito" esté en tu consulta
                    tuple.get("direccion", String.class),     // Asegúrate de que "direccion" esté en tu consulta
                    tuple.get("telefono", String.class)       // Asegúrate de que "telefono" esté en tu consulta
            );
            listaRefugios.add(refugioInfo);
        }
        return listaRefugios;
    }

}
