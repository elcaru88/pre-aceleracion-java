package com.alkemy.preaceleracion.dto;

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
public class CiudadDTO {

	private String imagen;

	private String denominacion;

	private Long habitantes;

	private Long superficie;

	private List<IconoGeograficoDTO> iconosGeograficos;

	private ContinenteDTO continente;
	
	public Ciudad buildEntity() {
		return Ciudad.builder()
				.imagen(this.imagen)
				.denominacion(this.denominacion)
				.habitantes(this.habitantes)
				.superficie(this.superficie)
				.build();
	}
	
	
	public Ciudad buildEntity(Long id) {
		return Ciudad.builder()
				.ciudadId(id)
				.imagen(this.imagen)
				.denominacion(this.denominacion)
				.habitantes(this.habitantes)
				.superficie(this.superficie)
				.build();
	}
	
	public static CiudadDTO from(Ciudad entity) {
		return CiudadDTO.builder()
				.imagen(entity.getImagen())
				.denominacion(entity.getDenominacion())
				.habitantes(entity.getHabitantes())
				.superficie(entity.getSuperficie())
				.build();
	}
}
