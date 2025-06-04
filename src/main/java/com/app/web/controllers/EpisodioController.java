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

import com.app.persistence.entities.Episodio;
import com.app.services.EpisodioService;
import com.app.services.dtos.EpisodioDTO;
import com.app.services.mappers.EpisodioMapper;

@RestController
@RequestMapping("/episodios")
@CrossOrigin(origins = "http://localhost:4200")
public class EpisodioController {
	
	@Autowired
	private EpisodioService episodioService;

	@GetMapping
	public ResponseEntity<List<EpisodioDTO>> episodios() {
		List<Episodio> episodios = this.episodioService.findAll();
		List<EpisodioDTO> episodiosDTO = new ArrayList<>();
		for (Episodio episodio : episodios) {
			episodiosDTO.add(EpisodioMapper.toDto(episodio));
		}
		return ResponseEntity.ok(episodiosDTO);
	}

    @GetMapping("/{idEpisodio}")
	public ResponseEntity<EpisodioDTO> episodio(@PathVariable int idEpisodio) {
		Optional<Episodio> episodio = this.episodioService.findById(idEpisodio);
		if (episodio.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(EpisodioMapper.toDto(episodio.get()));
	}
    
    @PostMapping
	public ResponseEntity<EpisodioDTO> create(@RequestBody Episodio episodio) {
    	Episodio savedEpisodio = episodioService.create(episodio);
    	EpisodioDTO episodioDTO = EpisodioMapper.toDto(savedEpisodio);
		return new ResponseEntity<>(episodioDTO, HttpStatus.CREATED);
	}

	@PutMapping("/{idEpisodio}")
	public ResponseEntity<EpisodioDTO> update(@PathVariable int idEpisodio,
			@RequestBody EpisodioDTO episodioDTO) {
		if (idEpisodio != episodioDTO.getId()) {
			return ResponseEntity.badRequest().build();
		}
		if (!episodioService.existsEpisodio(idEpisodio)) {
			return ResponseEntity.notFound().build();
		}

		Episodio episodio = EpisodioMapper.toEntity(episodioDTO);
		Episodio updatedEpisodio = episodioService.save(episodio);
		EpisodioDTO responseDTO = EpisodioMapper.toDto(updatedEpisodio);

		return ResponseEntity.ok(responseDTO);
	}

	@DeleteMapping("/{idEpisodio}")
	public ResponseEntity<EpisodioDTO> delete(@PathVariable int idEpisodio) {
		EpisodioDTO episodioEliminado = episodioService.delete(idEpisodio);

		if (episodioEliminado != null) {
			return ResponseEntity.ok(episodioEliminado);
		}

		return ResponseEntity.notFound().build();
	}
}
