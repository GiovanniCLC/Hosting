package com.manus.pratica.hospedagem.service;

import com.manus.pratica.hospedagem.model.Documento;
import com.manus.pratica.hospedagem.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> findAll() {
        return documentoRepository.findAll();
    }

    public Optional<Documento> findById(Long id) {
        return documentoRepository.findById(id);
    }

    public Documento save(Documento documento) {
        return documentoRepository.save(documento);
    }

    public void deleteById(Long id) {
        documentoRepository.deleteById(id);
    }
}
