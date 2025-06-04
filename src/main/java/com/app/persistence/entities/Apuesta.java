package com.app.persistence.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "apuesta")
@Getter
@Setter
@NoArgsConstructor
public class Apuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String resultado;

	@ManyToOne
	@JoinColumn(name = "id_juego", referencedColumnName = "id", insertable = false, updatable = false)
	private Juego juego;
	
	@OneToMany(mappedBy = "apuesta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Apostador> participantes;



}
