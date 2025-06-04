package com.app.services.dtos;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JuegoDTO {
	
	private Integer id;
	private String nombre;
    private String reglas;
    private String resultado;
    private EpisodioDTO episodio;

}
