package com.app.services.mappers;

import com.app.persistence.entities.Episodio;
import com.app.services.dtos.EpisodioDTO;

public class EpisodioMapper {
	
	public static EpisodioDTO toDto(Episodio episodio) {
		if (episodio == null) {
			return null;
		}
		EpisodioDTO dto = new EpisodioDTO();
		dto.setId(episodio.getId());
		dto.setTemporada(episodio.getTemporada());
		dto.setNumeroEpisodio(episodio.getNumeroEpisodio());
		dto.setSinopsis(episodio.getSinopsis());

		return dto;

	}

	public static Episodio toEntity(EpisodioDTO dto) {
		Episodio epi = new Episodio();

		epi.setId(dto.getId());
		epi.setTemporada(dto.getTemporada());
		epi.setNumeroEpisodio(dto.getNumeroEpisodio());
		epi.setSinopsis(dto.getSinopsis());
		
		return epi;
	}

}
