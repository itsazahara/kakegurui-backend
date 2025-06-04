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
import com.app.persistence.entities.Apuesta;
import com.app.services.ApostadorService;
import com.app.services.ApuestaService;
import com.app.services.dtos.ApostadorDTO;
import com.app.services.dtos.ApuestaDTO;
import com.app.services.mappers.ApostadorMapper;
import com.app.services.mappers.ApuestaMapper;

@RestController
@RequestMapping("/apuestas")
@CrossOrigin(origins = "http://localhost:4200")
public class ApuestaController {

	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	private ApostadorService apostadorService;

	@GetMapping
	public ResponseEntity<List<ApuestaDTO>> apuestas() {
		List<Apuesta> apuestas = this.apuestaService.findAll();
		List<ApuestaDTO> apuestasDTO = new ArrayList<>();
		for (Apuesta apuesta : apuestas) {
			apuestasDTO.add(ApuestaMapper.toDto(apuesta));
		}
		return ResponseEntity.ok(apuestasDTO);
	}

	@GetMapping("/{idApuesta}")
	public ResponseEntity<ApuestaDTO> apuesta(@PathVariable int idApuesta) {
		Optional<Apuesta> apuesta = this.apuestaService.findById(idApuesta);
		if (apuesta.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(ApuestaMapper.toDto(apuesta.get()));
	}

	@PostMapping
	public ResponseEntity<ApuestaDTO> create(@RequestBody Apuesta apuesta) {
		Apuesta savedApuesta = apuestaService.create(apuesta);
		ApuestaDTO apuestaDTO = ApuestaMapper.toDto(savedApuesta);
		return new ResponseEntity<>(apuestaDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idApuesta}")
	public ResponseEntity<ApuestaDTO> update(@PathVariable int idApuesta, @RequestBody ApuestaDTO apuestaDTO) {
		if (idApuesta != apuestaDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!apuestaService.existsApuesta(idApuesta)) {
			return ResponseEntity.notFound().build();
		}

		Apuesta apuesta = ApuestaMapper.toEntity(apuestaDTO);
		Apuesta updatedApuesta = apuestaService.save(apuesta);
		ApuestaDTO responseDTO = ApuestaMapper.toDto(updatedApuesta);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idApuesta}")
	public ResponseEntity<ApuestaDTO> delete(@PathVariable int idApuesta) {
		ApuestaDTO apuestaEliminado = apuestaService.delete(idApuesta);

		if (apuestaEliminado != null) {
			return ResponseEntity.ok(apuestaEliminado);
		}

		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/{id}/apostadores")
	public ResponseEntity<List<ApostadorDTO>> getApostadoresByApuestaId(@PathVariable int id) {
	    List<Apostador> apostadores = apostadorService.findByApuestaId(id);
	    List<ApostadorDTO> dtoList = apostadores.stream()
	            .map(ApostadorMapper::toDto)
	            .toList();
	    return ResponseEntity.ok(dtoList);
	}



}
