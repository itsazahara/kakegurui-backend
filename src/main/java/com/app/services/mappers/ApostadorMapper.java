package com.app.services.mappers;

import com.app.persistence.entities.Apostador;
import com.app.services.dtos.ApostadorDTO;

public class ApostadorMapper {

	public static ApostadorDTO toDto(Apostador apostador) {
		if (apostador == null) {
			return null;
		}
		ApostadorDTO dto = new ApostadorDTO();
		dto.setId(apostador.getId());
		dto.setPersonaje(PersonajeMapper.toDto(apostador.getPersonaje()));
		dto.setItemApostado(apostador.getItemApostado());
		dto.setResultado(apostador.getResultado());

		return dto;

	}

	public static Apostador toEntity(ApostadorDTO dto) {
		Apostador apostador = new Apostador();

		apostador.setId(dto.getId());
		apostador.setPersonaje(PersonajeMapper.toEntity(dto.getPersonaje()));
		apostador.setItemApostado(dto.getItemApostado());
		apostador.setResultado(dto.getResultado());

		return apostador;
	}

}
