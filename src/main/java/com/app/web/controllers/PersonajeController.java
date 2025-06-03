package com.app.web.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.persistence.entities.Personaje;
import com.app.services.PersonajeService;

@RestController
@RequestMapping("/personajes")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonajeController {
	
	@Autowired
    private PersonajeService personajeService;

    @GetMapping
    public List<Personaje> getAll() {
        return personajeService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Personaje> getById(@PathVariable Integer id) {
        return personajeService.findById(id);
    }

    @PostMapping
    public Personaje create(@RequestBody Personaje personaje) {
        return personajeService.save(personaje);
    }

    @PutMapping("/{id}")
    public Personaje update(@PathVariable Integer id, @RequestBody Personaje personaje) {
        personaje.setId(id);
        return personajeService.save(personaje);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        personajeService.deleteById(id);
    }

}
