package com.alkemy.preaceleracion.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.preaceleracion.dto.IconoGeograficoDTO;
import com.alkemy.preaceleracion.service.IconoGeograficoService;

@RestController
@RequestMapping("/iconos")
public class IconoGeograficoRest {

	@Autowired
	IconoGeograficoService iconoGeograficoService;

	@GetMapping
	public ResponseEntity<List<IconoGeograficoDTO>> listIconosGeograficos(
			@RequestParam(value = "denominacion", required = false) Optional<String> denominacion,
			@RequestParam(value = "fechacreacion", required = false) Optional<String> fechaCreacion,
			@RequestParam(value = "altura", required = false) Optional<String> altura,
			@RequestParam(value = "ciudades", required = false) Optional<String> ciudades) {
		Map<String, String> queryParam = buildQueryMap(denominacion, fechaCreacion, altura, ciudades);
		List<IconoGeograficoDTO> result = iconoGeograficoService.searchIconoGeografico(queryParam);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<IconoGeograficoDTO> createIconoGeografico(@RequestBody IconoGeograficoDTO iconoGeografico) {
		if (iconoGeograficoService.createIconoGeografico(iconoGeografico)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(iconoGeografico);
		}
		return ResponseEntity.status(400).body(iconoGeografico);
	}

	@PutMapping("/{id}")
	public ResponseEntity<IconoGeograficoDTO> updateIconoGeografico(@PathParam("id") Long id,
			@RequestBody IconoGeograficoDTO iconoGeografico) {
		if (iconoGeograficoService.updateIconoGeografico(id, iconoGeografico)) {
			return ResponseEntity.ok(iconoGeografico);
		}
		return ResponseEntity.status(400).body(iconoGeografico);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteIconoGeografico(@PathParam("id") Long id) {
		if (iconoGeograficoService.deleteIconoGeografico(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(400).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<IconoGeograficoDTO> getIconoGeografico(@PathParam("id") Long id) {
		IconoGeograficoDTO icono = iconoGeograficoService.getIconoGeografico(id);
		return ResponseEntity.ok(icono);
	}

	private Map<String, String> buildQueryMap(Optional<String> oDenominacion, Optional<String> oFechaCreacion,
			Optional<String> oAltura, Optional<String> oCiudades) {
		Map<String, String> queryParam = new HashMap<>();
		oDenominacion.ifPresent(denominacion -> queryParam.put("denominacion", denominacion));
		oFechaCreacion.ifPresent(fechaCreacion -> queryParam.put("fecha_creacion", fechaCreacion));
		oAltura.ifPresent(altura -> queryParam.put("altura", altura));
		oCiudades.ifPresent(ciudades -> queryParam.put("ciudades", ciudades));
		return queryParam;
	}

}
