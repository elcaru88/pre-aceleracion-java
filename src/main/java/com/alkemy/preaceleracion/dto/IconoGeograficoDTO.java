package com.alkemy.preaceleracion.dto;

import java.util.Date;
import java.util.List;

import com.alkemy.preaceleracion.model.IconoGeografico;
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

	private List<CiudadDTO> ciudades;
	
	public IconoGeografico buildEntity() {
		return IconoGeografico.builder()
				.imagen(this.imagen)
				.denominacion(this.denominacion)
				.creacion(this.creacion)
				.altura(this.altura)
				.historia(this.historia)
				.build();
	}
	
	
	public IconoGeografico buildEntity(Long id) {
		return IconoGeografico.builder()
				.iconoGeograficoId(id)
				.imagen(this.imagen)
				.denominacion(this.denominacion)
				.creacion(this.creacion)
				.altura(this.altura)
				.historia(this.historia)
				.build();
	}
	
	public static IconoGeograficoDTO from(IconoGeografico entity) {
		return IconoGeograficoDTO.builder()
				.imagen(entity.getImagen())
				.denominacion(entity.getDenominacion())
				.creacion(entity.getCreacion())
				.altura(entity.getAltura())
				.historia(entity.getHistoria())
				.build();
	}
}
