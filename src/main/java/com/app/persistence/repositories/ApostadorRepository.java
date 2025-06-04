package com.app.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Apostador;

public interface ApostadorRepository extends ListCrudRepository<Apostador, Integer>{
	
	List<Apostador> findByApuestaId(int apuestaId);


}
