package com.app.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.persistence.entities.Personaje;
import com.app.services.PersonajeService;
import com.app.services.dtos.PersonajeDTO;
import com.app.services.mappers.PersonajeMapper;

@RestController
@RequestMapping("/personajes")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonajeController {

	@Autowired
	private PersonajeService personajeService;

	@GetMapping
	public ResponseEntity<List<PersonajeDTO>> personajes() {
		List<Personaje> personajes = this.personajeService.findAll();
		List<PersonajeDTO> personajesDTO = new ArrayList<>();
		for (Personaje personaje : personajes) {
			personajesDTO.add(PersonajeMapper.toDto(personaje));
		}
		return ResponseEntity.ok(personajesDTO);
	}

	@GetMapping("/{idPersonaje}")
	public ResponseEntity<PersonajeDTO> personaje(@PathVariable int idPersonaje) {
		Optional<Personaje> personaje = this.personajeService.findById(idPersonaje);
		if (personaje.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(PersonajeMapper.toDto(personaje.get()));
	}

	@PostMapping
	public ResponseEntity<PersonajeDTO> create(@RequestBody Personaje personaje) {
		Personaje savedPersonaje = personajeService.create(personaje);
		PersonajeDTO personajeDTO = PersonajeMapper.toDto(savedPersonaje);
		return new ResponseEntity<>(personajeDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idPersonaje}")
	public ResponseEntity<PersonajeDTO> update(@PathVariable int idPersonaje, @RequestBody PersonajeDTO personajeDTO) {
		if (idPersonaje != personajeDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!personajeService.existsPersonaje(idPersonaje)) {
			return ResponseEntity.notFound().build();
		}

		Personaje personaje = PersonajeMapper.toEntity(personajeDTO);
		Personaje updatedPersonaje = personajeService.save(personaje);
		PersonajeDTO responseDTO = PersonajeMapper.toDto(updatedPersonaje);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idPersonaje}")
	public ResponseEntity<PersonajeDTO> delete(@PathVariable int idPersonaje) {
		PersonajeDTO personajeEliminado = personajeService.delete(idPersonaje);

		if (personajeEliminado != null) {
			return ResponseEntity.ok(personajeEliminado);
		}

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/buscador")
	public ResponseEntity<List<PersonajeDTO>> searchByNombre(@RequestParam String nombre) {
		List<Personaje> personajes = personajeService.findByNombreContainingIgnoreCase(nombre);
		List<PersonajeDTO> personajesDTO = personajes.stream().map(p -> PersonajeMapper.toDto(p)).toList();
		return ResponseEntity.ok(personajesDTO);
	}

}
