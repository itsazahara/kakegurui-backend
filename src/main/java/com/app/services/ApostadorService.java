package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Apostador;
import com.app.persistence.repositories.ApostadorRepository;
import com.app.services.dtos.ApostadorDTO;
import com.app.services.mappers.ApostadorMapper;

@Service
public class ApostadorService {

	@Autowired
	private ApostadorRepository apostadorRepository;

	public List<Apostador> findAll() {
		return apostadorRepository.findAll();
	}

	public Optional<Apostador> findById(Integer id) {
		return apostadorRepository.findById(id);
	}
	
	public boolean existsApostador(int idApostador) {
	    return this.apostadorRepository.existsById(idApostador);
	}
	
	public Apostador create(Apostador apostador) {
		return this.apostadorRepository.save(apostador);
	}

	public Apostador save(Apostador apostador) {
		return apostadorRepository.save(apostador);
	}

	public ApostadorDTO delete(int idApostador) {
		Optional<Apostador> apostadorOptional = apostadorRepository.findById(idApostador);

		if (apostadorOptional.isPresent()) {
			Apostador apostador = apostadorOptional.get();
			apostadorRepository.delete(apostador);
			return ApostadorMapper.toDto(apostador);
		}

		return null;
	}

}
