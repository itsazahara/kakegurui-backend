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

import com.app.persistence.entities.Apostador;
import com.app.services.ApostadorService;
import com.app.services.dtos.ApostadorDTO;
import com.app.services.mappers.ApostadorMapper;

@RestController
@RequestMapping("/apostadores")
@CrossOrigin(origins = "http://localhost:4200")
public class ApostadorController {
	
	@Autowired
	private ApostadorService apostadorService;
	
	@GetMapping
	public ResponseEntity<List<ApostadorDTO>> apostadores() {
		List<Apostador> apostadores = this.apostadorService.findAll();
		List<ApostadorDTO> apostadoresDTO = new ArrayList<>();
		for (Apostador apostador : apostadores) {
			apostadoresDTO.add(ApostadorMapper.toDto(apostador));
		}
		return ResponseEntity.ok(apostadoresDTO);
	}

    @GetMapping("/{idApostador}")
	public ResponseEntity<ApostadorDTO> apostador(@PathVariable int idApostador) {
		Optional<Apostador> apostador = this.apostadorService.findById(idApostador);
		if (apostador.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(ApostadorMapper.toDto(apostador.get()));
	}
    
    @PostMapping
	public ResponseEntity<ApostadorDTO> create(@RequestBody Apostador apostador) {
    	Apostador savedApostador = apostadorService.create(apostador);
    	ApostadorDTO apostadorDTO = ApostadorMapper.toDto(savedApostador);
		return new ResponseEntity<>(apostadorDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idApostador}")
	public ResponseEntity<ApostadorDTO> update(@PathVariable int idApostador,
			@RequestBody ApostadorDTO apostadorDTO) {
		if (idApostador != apostadorDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!apostadorService.existsApostador(idApostador)) {
			return ResponseEntity.notFound().build();
		}

		Apostador episodio = ApostadorMapper.toEntity(apostadorDTO);
		Apostador updatedApostador = apostadorService.save(episodio);
		ApostadorDTO responseDTO = ApostadorMapper.toDto(updatedApostador);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idApostador}")
	public ResponseEntity<ApostadorDTO> delete(@PathVariable int idApostador) {
		ApostadorDTO apostadorEliminado = apostadorService.delete(idApostador);

		if (apostadorEliminado != null) {
			return ResponseEntity.ok(apostadorEliminado);
		}

		return ResponseEntity.notFound().build();
	}

}
