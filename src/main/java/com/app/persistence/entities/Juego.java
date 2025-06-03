package com.app.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "juego")
@Getter
@Setter
@NoArgsConstructor
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String nombre;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String reglas;

	@ManyToOne
	@JoinColumn(name = "id_episodio", referencedColumnName = "id", insertable = false, updatable = false)
	private Episodio episodio;

	@OneToMany(mappedBy = "juego", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Apuesta> apuestas;

}
