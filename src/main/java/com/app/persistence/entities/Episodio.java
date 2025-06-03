package com.app.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "episodio")
@Getter
@Setter
@NoArgsConstructor
public class Episodio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer temporadas;

	@Column(name = "numero_episodio", nullable = false)
	private Integer numeroEpisodio;

	@Column(columnDefinition = "TEXT")
	private String sinopsis;

	@OneToMany(mappedBy = "episodio", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Juego> juegos;

}
