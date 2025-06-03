package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.persistence.entities.Episodio;
import com.app.persistence.repositories.EpisodioRepository;

@Service
public class EpisodioService {

	@Autowired
	private EpisodioRepository episodioRepository;
	
	public List<Episodio> findAll() {
        return episodioRepository.findAll();
    }
	
	public boolean existsEpisodio(int idEpisodio){
		return this.episodioRepository.existsById(idEpisodio);
	}
	
	public Optional<Episodio> findById(int idEpisodio){
		return this.episodioRepository.findById(idEpisodio);
	}
	
	public Episodio create(Episodio episodio) {
		return this.episodioRepository.save(episodio);
	}
	
	public Episodio save(Episodio episodio) {
		return this.episodioRepository.save(episodio);
	}
	
	public void deleteById(Integer id) {
		episodioRepository.deleteById(id);
    }
}
