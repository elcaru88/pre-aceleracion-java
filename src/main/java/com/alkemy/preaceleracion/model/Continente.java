package com.alkemy.preaceleracion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Continente {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long continenteId;

	@Column
	private String imagen;

	@Column
	private String denominacion;

	@OneToMany(mappedBy = "continente")
	private List<Ciudad> ciudades;
}
