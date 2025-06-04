package com.app.services.dtos;

import com.app.persistence.entities.enumerados.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonajeDTO {
	
	private Integer id;
	private String nombre;
    private Integer edad;
    private Role role;
    private String imagen;
    private String descripcion;

}
