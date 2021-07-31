package com.alkemy.preaceleracion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alkemy.preaceleracion.dto.IconoGeograficoDTO;
import com.alkemy.preaceleracion.model.IconoGeografico;

@Service
public class IconoGeograficoService {

	public List<IconoGeograficoDTO> searchIconoGeografico(Map<String, String> queryParam) {
		List<IconoGeograficoDTO> result = new ArrayList<>();
		IconoGeograficoDTO icono1 = IconoGeograficoDTO.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		IconoGeograficoDTO icono2 = IconoGeograficoDTO.builder().denominacion("Estatua de la Libertad").imagen("IMAGEN")
				.build();
		IconoGeograficoDTO icono3 = IconoGeograficoDTO.builder().denominacion("Coliseo").imagen("IMAGEN").build();
		result.add(icono1);
		result.add(icono2);
		result.add(icono3);
		return result;
	}

	public Boolean createIconoGeografico(IconoGeograficoDTO iconoGeograficoDTO) {
		IconoGeografico iconoGeografico = iconoGeograficoDTO.buildEntity();
		return true;
	}

	public Boolean updateIconoGeografico(Long id, IconoGeograficoDTO iconoGeograficoDTO) {
		IconoGeografico iconoGeografico = iconoGeograficoDTO.buildEntity(id);
		return true;
	}

	public Boolean deleteIconoGeografico(Long id) {
		return true;
	}

	public IconoGeograficoDTO getIconoGeografico(Long id) {
		IconoGeografico iconoEntity = IconoGeografico.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		return IconoGeograficoDTO.from(iconoEntity);
	}

}
