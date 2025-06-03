package com.app.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Juego;

public interface JuegoRepository extends ListCrudRepository<Juego, Integer>{

}
