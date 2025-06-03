package com.app.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "apuesta")
@Getter
@Setter
@NoArgsConstructor
public class Apuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "id_personaje", referencedColumnName = "id", insertable = false, updatable = false)
	private Personaje personaje;

	@ManyToOne
	@JoinColumn(name = "id_juego", referencedColumnName = "id", insertable = false, updatable = false)
	private Juego juego;

}
