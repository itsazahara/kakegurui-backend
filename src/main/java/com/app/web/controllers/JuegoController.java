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

import com.app.persistence.entities.Juego;
import com.app.services.JuegoService;

@RestController
@RequestMapping("/juegos")
@CrossOrigin(origins = "http://localhost:4200")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;

	@GetMapping
	public List<Juego> getAll() {
		return juegoService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Juego> getById(@PathVariable Integer id) {
		return juegoService.findById(id);
	}

	@PostMapping
	public Juego create(@RequestBody Juego j) {
		return juegoService.save(j);
	}

	@PutMapping("/{id}")
	public Juego update(@PathVariable Integer id, @RequestBody Juego j) {
		j.setId(id);
		return juegoService.save(j);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		juegoService.deleteById(id);
	}
}
