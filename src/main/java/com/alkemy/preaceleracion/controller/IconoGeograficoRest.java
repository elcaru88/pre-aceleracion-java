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

import com.alkemy.preaceleracion.dto.IconoGeograficoDTO;

@RestController
@RequestMapping("/iconos")
public class IconoGeograficoRest {

	@GetMapping
	public ResponseEntity<List<IconoGeograficoDTO>> listIconosGeograficos(
			@RequestParam(value = "denominacion", required = false) String denominacion,
			@RequestParam(value = "fechacreacion", required = false) String fechaCreacion,
			@RequestParam(value = "altura", required = false) Integer altura,
			@RequestParam(value = "ciudades", required = false) String[] ciudades) {
		List<IconoGeograficoDTO> result = new ArrayList<>();
		IconoGeograficoDTO icono1 = IconoGeograficoDTO.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		IconoGeograficoDTO icono2 = IconoGeograficoDTO.builder().denominacion("Estatua de la Libertad").imagen("IMAGEN")
				.build();
		IconoGeograficoDTO icono3 = IconoGeograficoDTO.builder().denominacion("Coliseo").imagen("IMAGEN").build();
		result.add(icono1);
		result.add(icono2);
		result.add(icono3);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<IconoGeograficoDTO> createIconoGeografico() {
		IconoGeograficoDTO icono = IconoGeograficoDTO.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		return ResponseEntity.status(HttpStatus.CREATED).body(icono);
	}

	@PutMapping
	public ResponseEntity<IconoGeograficoDTO> updateIconoGeografico() {
		IconoGeograficoDTO icono = IconoGeograficoDTO.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		return ResponseEntity.ok(icono);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteIconoGeografico(@PathParam("id") String id) {
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<IconoGeograficoDTO> getIconoGeografico(@PathParam("id") String id) {
		IconoGeograficoDTO icono = IconoGeograficoDTO.builder().denominacion("Torre Eiffel").imagen("IMAGEN").build();
		return ResponseEntity.ok(icono);
	}

}
