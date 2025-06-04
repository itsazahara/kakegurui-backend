package com.app.services.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EpisodioDTO {
	
	private Integer id;
	private Integer temporada;
    private Integer numeroEpisodio;
    private String sinopsis;

}
