package com.app.persistence.entities;


import com.app.persistence.entities.enumerados.Resultado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "apostador")
@Getter
@Setter
@NoArgsConstructor
public class Apostador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_apuesta", nullable = false)
	private Apuesta apuesta;

    @ManyToOne
    @JoinColumn(name = "id_personaje", nullable = false)
    private Personaje personaje;

    @Column(name = "item_apostado")
    private String itemApostado;

    @Enumerated(EnumType.STRING)
    private Resultado resultado;

}
