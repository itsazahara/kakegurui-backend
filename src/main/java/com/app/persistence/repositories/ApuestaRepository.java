package com.app.persistence.repositories;


import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Apuesta;

public interface ApuestaRepository extends ListCrudRepository<Apuesta, Integer>{
	

}
