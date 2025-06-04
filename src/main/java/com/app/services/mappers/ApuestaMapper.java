package com.app.services.mappers;

import java.util.stream.Collectors;

import com.app.persistence.entities.Apuesta;
import com.app.services.dtos.ApuestaDTO;

public class ApuestaMapper {

	public static ApuestaDTO toDto(Apuesta apuesta) {
		if (apuesta == null) {
			return null;
		}
		ApuestaDTO dto = new ApuestaDTO();
		dto.setId(apuesta.getId());
		dto.setDescripcion(apuesta.getDescripcion());
		dto.setJuego(JuegoMapper.toDto(apuesta.getJuego()));
		dto.setParticipantes(
				apuesta.getParticipantes().stream().map(ApostadorMapper::toDto).collect(Collectors.toList()));

		return dto;

	}

	public static Apuesta toEntity(ApuestaDTO dto) {
		Apuesta apuesta = new Apuesta();

		apuesta.setId(dto.getId());
		apuesta.setDescripcion(dto.getDescripcion());
		apuesta.setJuego(JuegoMapper.toEntity(dto.getJuego()));
		apuesta.setParticipantes(
				dto.getParticipantes().stream().map(ApostadorMapper::toEntity).collect(Collectors.toList()));

		return apuesta;
	}

}
