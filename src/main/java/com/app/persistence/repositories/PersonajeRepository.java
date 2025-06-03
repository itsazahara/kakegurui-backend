package com.app.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Personaje;

public interface PersonajeRepository extends ListCrudRepository<Personaje, Integer>{

}
