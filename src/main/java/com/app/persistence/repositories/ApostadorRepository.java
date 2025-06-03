package com.app.persistence.repositories;

import org.springframework.data.repository.ListCrudRepository;

import com.app.persistence.entities.Apostador;

public interface ApostadorRepository extends ListCrudRepository<Apostador, Integer>{

}
