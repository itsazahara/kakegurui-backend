package com.app.services.mappers;

import com.app.persistence.entities.Personaje;
import com.app.services.dtos.PersonajeDTO;

public class PersonajeMapper {

	public static PersonajeDTO toDto(Personaje personaje) {
		if (personaje == null) {
			return null;
		}
		PersonajeDTO dto = new PersonajeDTO();
		dto.setId(personaje.getId());
		dto.setNombre(personaje.getNombre());
		dto.setEdad(personaje.getEdad());
		dto.setRole(personaje.getRole());
		dto.setImagen(personaje.getImagen());
		dto.setDescripcion(personaje.getDescripcion());

		return dto;

	}

	public static Personaje toEntity(PersonajeDTO dto) {
		Personaje pers = new Personaje();

		pers.setId(dto.getId());
		pers.setNombre(dto.getNombre());
		pers.setEdad(dto.getEdad());
		pers.setRole(dto.getRole());
		pers.setImagen(dto.getImagen());
		pers.setDescripcion(dto.getDescripcion());

		return pers;
	}

}
