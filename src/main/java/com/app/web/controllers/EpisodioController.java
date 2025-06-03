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

import com.app.persistence.entities.Episodio;
import com.app.services.EpisodioService;

@RestController
@RequestMapping("/episodios")
@CrossOrigin(origins = "http://localhost:4200")
public class EpisodioController {
	
	@Autowired
	private EpisodioService episodioService;

	@GetMapping
	public List<Episodio> getAll() {
		return episodioService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Episodio> getById(@PathVariable Integer id) {
		return episodioService.findById(id);
	}

	@PostMapping
	public Episodio create(@RequestBody Episodio e) {
		return episodioService.save(e);
	}

	@PutMapping("/{id}")
	public Episodio update(@PathVariable Integer id, @RequestBody Episodio e) {
		e.setId(id);
		return episodioService.save(e);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		episodioService.deleteById(id);
	}
}
