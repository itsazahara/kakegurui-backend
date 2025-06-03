package com.app.persistence.entities;

import java.util.List;

import com.app.persistence.entities.enumerados.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@NoArgsConstructor
public class Personaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private Integer edad;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String imagen;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String descripcion;
	
	@OneToMany(mappedBy = "personaje", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<Apostador> apuestas;

}
