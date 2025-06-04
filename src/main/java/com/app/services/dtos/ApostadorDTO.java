package com.app.services.dtos;

import com.app.persistence.entities.enumerados.Resultado;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApostadorDTO {
	
	private Integer id;
	private PersonajeDTO personaje;
    private String itemApostado;
    private Resultado resultado;

}
