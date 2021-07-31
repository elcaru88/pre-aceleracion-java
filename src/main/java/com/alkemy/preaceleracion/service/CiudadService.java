package com.alkemy.preaceleracion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alkemy.preaceleracion.dto.CiudadDTO;
import com.alkemy.preaceleracion.model.Ciudad;

@Service
public class CiudadService {

	public List<CiudadDTO> searchCiudad(Map<String, String> queryParam) {
		List<CiudadDTO> result = new ArrayList<>();
		CiudadDTO ciudad1 = CiudadDTO.builder().denominacion("Paris").imagen("IMAGEN").build();
		CiudadDTO ciudad2 = CiudadDTO.builder().denominacion("Nueva York").imagen("IMAGEN").build();
		CiudadDTO ciudad3 = CiudadDTO.builder().denominacion("Italia").imagen("IMAGEN").build();
		result.add(ciudad1);
		result.add(ciudad2);
		result.add(ciudad3);
		return result;
	}

	public Boolean createCiudad(CiudadDTO ciudadDTO) {
		Ciudad ciudad = ciudadDTO.buildEntity();
		return true;
	}

	public Boolean updateCiudad(Long id, CiudadDTO ciudadDTO) {
		Ciudad ciudad = ciudadDTO.buildEntity(id);
		return true;
	}

	public Boolean deleteCiudad(Long id) {
		return true;
	}

	public CiudadDTO getCiudad(Long id) {
		Ciudad ciudadEntity = Ciudad.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		return CiudadDTO.from(ciudadEntity);
	}

}
