package com.app.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Episodio;

public interface EpisodioRepository extends ListCrudRepository<Episodio, Integer>{

}
