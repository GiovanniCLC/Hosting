package com.manus.pratica.hospedagem.controller;

import com.manus.pratica.hospedagem.model.Documento;
import com.manus.pratica.hospedagem.model.Categoria;
import com.manus.pratica.hospedagem.service.DocumentoService;
import com.manus.pratica.hospedagem.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Documento> getAllDocumentos() {
        return documentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Documento> getDocumentoById(@PathVariable Long id) {
        return documentoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Documento> createDocumento(@RequestBody Documento documento) {
        // Garante que a categoria existe antes de salvar o documento
        return categoriaService.findById(documento.getCategoria().getId())
                .map(categoria -> {
                    documento.setCategoria(categoria);
                    Documento savedDocumento = documentoService.save(documento);
                    return new ResponseEntity<>(savedDocumento, HttpStatus.CREATED);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST)); // Categoria não encontrada
    }

    @PutMapping("/{id}")
    public ResponseEntity<Documento> updateDocumento(@PathVariable Long id, @RequestBody Documento documentoDetails) {
        return documentoService.findById(id)
                .flatMap(documento -> categoriaService.findById(documentoDetails.getCategoria().getId())
                        .map(categoria -> {
                            documento.setTitulo(documentoDetails.getTitulo());
                            documento.setConteudo(documentoDetails.getConteudo());
                            documento.setCategoria(categoria);
                            return ResponseEntity.ok(documentoService.save(documento));
                        })
                )
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocumento(@PathVariable Long id) {
        if (documentoService.findById(id).isPresent()) {
            documentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
