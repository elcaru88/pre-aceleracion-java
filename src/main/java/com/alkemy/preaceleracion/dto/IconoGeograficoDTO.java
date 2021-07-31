package com.alkemy.preaceleracion.dto;

import java.util.Date;
import java.util.List;

import com.alkemy.preaceleracion.model.Ciudad;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IconoGeograficoDTO {

	private String imagen;

	private String denominacion;

	private Date creacion;

	private Long altura;

	private String historia;

	private List<Ciudad> ciudades;

}
