package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.CertificadoDTO;
import com.upc.amparo.entities.Certificado;
import com.upc.amparo.repositories.CertificadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service

public class CertificadoService {
    final CertificadoRepository certificadoRepository;

    public CertificadoService(CertificadoRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }

    public CertificadoDTO create(CertificadoDTO certificadoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Certificado certificado = modelMapper.map(certificadoDto, Certificado.class);
        certificadoRepository.save(certificado);
        return certificadoDto;
    }

    public void delete(Long id) {
        certificadoRepository.deleteById(id);
    }

    public CertificadoDTO update(Long id, CertificadoDTO certificadoDto) {
        Certificado certificado = certificadoRepository.findById(id).orElse(null);
        if (certificado != null) {
            ModelMapper modelMapper = new ModelMapper();
            certificado = modelMapper.map(certificadoDto, Certificado.class);
            certificado.setId(id);
            certificadoRepository.save(certificado);
            return certificadoDto;
        }
        return null;
    }
}
