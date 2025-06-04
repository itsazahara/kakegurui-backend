package com.app.services.dtos;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApuestaDTO {
	
	private Integer id;
	private String descripcion;
    private JuegoDTO juego;
    private List<ApostadorDTO> participantes;

}
