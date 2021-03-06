package com.alkemy.preaceleracion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Ciudad {

	@Id
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private Long ciudadId;

	@Column
	private String imagen;

	@Column
	private String denominacion;

	@Column
	private Long habitantes;

	@Column
	private Long superficie;

	@ManyToMany
	@JoinTable(name = "ciudad_icono", 
		joinColumns = @JoinColumn(name = "ciudad_id"), 
		inverseJoinColumns = @JoinColumn(name = "icono_geografico_id"))
	private List<IconoGeografico> iconosGeograficos;

	@ManyToOne
	@JoinColumn(name = "continente_id")
	private Continente continente;
}
