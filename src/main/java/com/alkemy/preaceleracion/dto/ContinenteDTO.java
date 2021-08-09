package com.alkemy.preaceleracion.dto;

import java.util.List;

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
public class ContinenteDTO {
	
	//CAMBIO PRUEBA

	private String imagen;

	private String denominacion;

	private List<CiudadDTO> ciudades;

}
