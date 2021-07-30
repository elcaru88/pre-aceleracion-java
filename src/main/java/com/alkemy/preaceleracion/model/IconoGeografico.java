package com.alkemy.preaceleracion.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class IconoGeografico {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long iconoGeograficoId;

	@Column
	private String imagen;

	@Column
	private String denominacion;

	@Column
	private Date creacion;

	@Column
	private Long altura;

	@Column
	private String historia;
	
	@ManyToMany(mappedBy = "iconosGeograficos")
	private List<Ciudad> ciudades;
}
