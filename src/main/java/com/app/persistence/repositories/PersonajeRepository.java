package com.app.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Personaje;

public interface PersonajeRepository extends ListCrudRepository<Personaje, Integer>{
	
	List<Personaje> findByNombreContainingIgnoreCase(String nombre);

}
