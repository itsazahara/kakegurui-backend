package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Juego;
import com.app.persistence.repositories.JuegoRepository;
import com.app.services.dtos.JuegoDTO;
import com.app.services.mappers.JuegoMapper;

@Service
public class JuegoService {
	
	@Autowired
	private JuegoRepository juegoRepository;
	
	public List<Juego> findAll() {
        return juegoRepository.findAll();
    }
	
	public boolean existsJuego(int idJuego){
		return this.juegoRepository.existsById(idJuego);
	}
	
	public Optional<Juego> findById(int idJuego){
		return this.juegoRepository.findById(idJuego);
	}
	
	public Juego create(Juego juego) {
		return this.juegoRepository.save(juego);
	}
	
	public Juego save(Juego juego) {
		return this.juegoRepository.save(juego);
	}
	
	public JuegoDTO delete(int idJuego) {
        Optional<Juego> juegoOptional = juegoRepository.findById(idJuego);

        if (juegoOptional.isPresent()) {
        	Juego juego = juegoOptional.get();
        	juegoRepository.delete(juego);
            return JuegoMapper.toDto(juego);
        }

        return null;
    }

}
