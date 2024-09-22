package com.upc.amparo.serviceinterfaces;

import com.upc.amparo.dto.DocumentoDTO;
import com.upc.amparo.entities.Documento;
import com.upc.amparo.repositories.DocumentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DocumentoService {
    final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public DocumentoDTO create(DocumentoDTO documentoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Documento documento = modelMapper.map(documentoDto, Documento.class);
        documentoRepository.save(documento);
        return documentoDto;
    }

    public void delete(Long id) {
        documentoRepository.deleteById(id);
    }

    public DocumentoDTO update(Long id, DocumentoDTO documentoDto) {
        Documento documento = documentoRepository.findById(id).orElse(null);
        if (documento != null) {
            ModelMapper modelMapper = new ModelMapper();
            documento = modelMapper.map(documentoDto, Documento.class);
            documento.setId(id);
            documentoRepository.save(documento);
            return documentoDto;
        }
        return null;
    }
}