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
import org.springframework.web.bind.annotation.RestController;

import com.app.persistence.entities.Juego;
import com.app.services.JuegoService;
import com.app.services.dtos.JuegoDTO;
import com.app.services.mappers.JuegoMapper;

@RestController
@RequestMapping("/juegos")
@CrossOrigin(origins = "http://localhost:4200")
public class JuegoController {

	@Autowired
	private JuegoService juegoService;

	@GetMapping
	public ResponseEntity<List<JuegoDTO>> juegos() {
		List<Juego> juegos = this.juegoService.findAll();
		List<JuegoDTO> juegosDTO = new ArrayList<>();
		for (Juego juego : juegos) {
			juegosDTO.add(JuegoMapper.toDto(juego));
		}
		return ResponseEntity.ok(juegosDTO);
	}

	@GetMapping("/{idPersonaje}")
	public ResponseEntity<JuegoDTO> juego(@PathVariable int idJuego) {
		Optional<Juego> juego = this.juegoService.findById(idJuego);
		if (juego.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(JuegoMapper.toDto(juego.get()));
	}

	@PostMapping
	public ResponseEntity<JuegoDTO> create(@RequestBody Juego juego) {
		Juego savedJuego = juegoService.create(juego);
		JuegoDTO juegoDTO = JuegoMapper.toDto(savedJuego);
		return new ResponseEntity<>(juegoDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idJuego}")
	public ResponseEntity<JuegoDTO> update(@PathVariable int idJuego, @RequestBody JuegoDTO juegoDTO) {
		if (idJuego != juegoDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!juegoService.existsJuego(idJuego)) {
			return ResponseEntity.notFound().build();
		}

		Juego juego = JuegoMapper.toEntity(juegoDTO);
		Juego updatedJuego = juegoService.save(juego);
		JuegoDTO responseDTO = JuegoMapper.toDto(updatedJuego);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idJuego}")
	public ResponseEntity<JuegoDTO> delete(@PathVariable int idJuego) {
		JuegoDTO juegoEliminado = juegoService.delete(idJuego);

		if (juegoEliminado != null) {
			return ResponseEntity.ok(juegoEliminado);
		}

		return ResponseEntity.notFound().build();
	}
}
