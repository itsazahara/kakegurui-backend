package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Apuesta;
import com.app.persistence.repositories.ApuestaRepository;
import com.app.services.dtos.ApuestaDTO;
import com.app.services.mappers.ApuestaMapper;

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
	
	public ApuestaDTO delete(int idApuesta) {
        Optional<Apuesta> apuestaOptional = apuestaRepository.findById(idApuesta);

        if (apuestaOptional.isPresent()) {
        	Apuesta apuesta = apuestaOptional.get();
        	apuestaRepository.delete(apuesta);
            return ApuestaMapper.toDto(apuesta);
        }

        return null;
    }
	
	


}
