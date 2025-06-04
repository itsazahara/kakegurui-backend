package com.app.services.mappers;

import com.app.persistence.entities.Juego;
import com.app.services.dtos.JuegoDTO;

public class JuegoMapper {

	public static JuegoDTO toDto(Juego juego) {
		if (juego == null) {
			return null;
		}
		JuegoDTO dto = new JuegoDTO();
		dto.setId(juego.getId());
		dto.setNombre(juego.getNombre());
		dto.setReglas(juego.getReglas());
		dto.setEpisodio(EpisodioMapper.toDto(juego.getEpisodio()));

		return dto;

	}

	public static Juego toEntity(JuegoDTO dto) {
		Juego juego = new Juego();

		juego.setId(dto.getId());
		juego.setNombre(dto.getNombre());
		juego.setReglas(dto.getReglas());
		juego.setEpisodio(EpisodioMapper.toEntity(dto.getEpisodio()));

		return juego;
	}

}
