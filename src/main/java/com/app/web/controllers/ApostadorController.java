package com.app.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.persistence.entities.Apostador;
import com.app.services.ApostadorService;

@RestController
@RequestMapping("/apostadores")
@CrossOrigin(origins = "http://localhost:4200")
public class ApostadorController {
	
	@Autowired
	private ApostadorService apostadorService;
	
	@GetMapping
    public List<Apostador> getAll() {
        return apostadorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Apostador> getById(@PathVariable Integer id) {
        return apostadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Apostador create(@RequestBody Apostador apostador) {
        return apostadorService.save(apostador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        apostadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
