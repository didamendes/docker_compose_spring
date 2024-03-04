package br.com.diogomendes.controller;

import br.com.diogomendes.model.Exemplo;
import br.com.diogomendes.repository.ExemploRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exemplo")
public class ExemploController {

    @Autowired
    private ExemploRepository exemploRepository;

    @GetMapping
    public ResponseEntity<List<Exemplo>> listar() {
        return ResponseEntity.ok(exemploRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exemplo> getExemplo(@PathVariable Long id) {
        Exemplo exemplo = exemploRepository.findById(id).orElse(null);
        return ResponseEntity.ok(exemplo);
    }

    @PostMapping
    public ResponseEntity<Exemplo> criar(@RequestBody Exemplo exemplo) {
        return ResponseEntity.ok(exemploRepository.save(exemplo));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        exemploRepository.deleteById(id);
    }

}
