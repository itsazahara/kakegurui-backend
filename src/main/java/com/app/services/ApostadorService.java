package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Apostador;
import com.app.persistence.repositories.ApostadorRepository;

@Service
public class ApostadorService {
	
	@Autowired
	private ApostadorRepository apostadorRepository;
	
    public List<Apostador> findAll() {
        return apostadorRepository.findAll();
    }

    public Optional<Apostador> findById(Integer id) {
        return apostadorRepository.findById(id);
    }

    public Apostador save(Apostador apostador) {
        return apostadorRepository.save(apostador);
    }

    public void deleteById(Integer id) {
        apostadorRepository.deleteById(id);
    }

}
