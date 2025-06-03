package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Apuesta;
import com.app.persistence.repositories.ApuestaRepository;

@Service
public class ApuestaService {

	@Autowired
	private ApuestaRepository apuestaRepository;
	
	public List<Apuesta> findAll() {
        return apuestaRepository.findAll();
    }
	
	public boolean existsApuesta(int idApuesta){
		return this.apuestaRepository.existsById(idApuesta);
	}
	
	public Optional<Apuesta> findById(int idApuesta){
		return this.apuestaRepository.findById(idApuesta);
	}
	
	public Apuesta create(Apuesta apuesta) {
		return this.apuestaRepository.save(apuesta);
	}
	
	public Apuesta save(Apuesta apuesta) {
		return this.apuestaRepository.save(apuesta);
	}
	
	public void deleteById(Integer id) {
		apuestaRepository.deleteById(id);
    }
}
