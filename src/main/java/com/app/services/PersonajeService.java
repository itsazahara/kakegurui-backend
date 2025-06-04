package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Personaje;
import com.app.persistence.repositories.PersonajeRepository;
import com.app.services.dtos.PersonajeDTO;
import com.app.services.mappers.PersonajeMapper;

@Service
public class PersonajeService {

	@Autowired
	private PersonajeRepository personajeRepository;

	public List<Personaje> findAll() {
		return personajeRepository.findAll();
	}

	public boolean existsPersonaje(int idPersonaje) {
		return this.personajeRepository.existsById(idPersonaje);
	}

	public Optional<Personaje> findById(int idPersonaje) {
		return this.personajeRepository.findById(idPersonaje);
	}

	public Personaje create(Personaje personaje) {
		return this.personajeRepository.save(personaje);
	}

	public Personaje save(Personaje personaje) {
		return this.personajeRepository.save(personaje);
	}

	public PersonajeDTO delete(int idPersonaje) {
		Optional<Personaje> personajeOptional = personajeRepository.findById(idPersonaje);

		if (personajeOptional.isPresent()) {
			Personaje personaje = personajeOptional.get();
			personajeRepository.delete(personaje);
			return PersonajeMapper.toDto(personaje);
		}

		return null;
	}

	public List<Personaje> findByNombreContainingIgnoreCase(String nombre) {
		return personajeRepository.findByNombreContainingIgnoreCase(nombre);
	}

}
