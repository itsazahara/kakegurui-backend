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

import com.app.persistence.entities.Apuesta;
import com.app.services.ApuestaService;

@RestController
@RequestMapping("/apuestas")
@CrossOrigin(origins = "http://localhost:4200")
public class ApuestaController {
	
	@Autowired
	private ApuestaService apuestService;

	@GetMapping
	public List<Apuesta> getAll() {
		return apuestService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Apuesta> getById(@PathVariable Integer id) {
		return apuestService.findById(id);
	}

	@PostMapping
	public Apuesta create(@RequestBody Apuesta a) {
		return apuestService.save(a);
	}

	@PutMapping("/{id}")
	public Apuesta update(@PathVariable Integer id, @RequestBody Apuesta a) {
		a.setId(id);
		return apuestService.save(a);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		apuestService.deleteById(id);
	}
}
