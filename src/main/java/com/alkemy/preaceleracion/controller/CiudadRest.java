package com.alkemy.preaceleracion.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.preaceleracion.dto.CiudadDTO;

@RestController
@RequestMapping("/ciudades")
public class CiudadRest {

	@GetMapping
	public ResponseEntity<List<CiudadDTO>> listCiudades(
			@RequestParam(value = "denominacion", required = false) String denominacion,
			@RequestParam(value = "continente", required = false) String continente,
			@RequestParam(value = "order", required = false) Integer order) {
		List<CiudadDTO> result = new ArrayList<>();
		CiudadDTO ciudad1 = CiudadDTO.builder().denominacion("Paris").imagen("IMAGEN").build();
		CiudadDTO ciudad2 = CiudadDTO.builder().denominacion("Nueva York").imagen("IMAGEN").build();
		CiudadDTO ciudad3 = CiudadDTO.builder().denominacion("Italia").imagen("IMAGEN").build();
		result.add(ciudad1);
		result.add(ciudad2);
		result.add(ciudad3);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<CiudadDTO> createCiudad() {
		CiudadDTO ciudad = CiudadDTO.builder().denominacion("Paris").imagen("IMAGEN").build();
		return ResponseEntity.status(HttpStatus.CREATED).body(ciudad);
	}

	@PutMapping
	public ResponseEntity<CiudadDTO> updateCiudad() {
		CiudadDTO ciudad = CiudadDTO.builder().denominacion("Paris").imagen("IMAGEN").build();
		return ResponseEntity.ok(ciudad);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCiudad(@PathParam("id") String id) {
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CiudadDTO> getCiudad(@PathParam("id") String id) {
		CiudadDTO ciudad = CiudadDTO.builder().denominacion("Paris").imagen("IMAGEN").build();
		return ResponseEntity.ok(ciudad);
	}

}
