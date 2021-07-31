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

import com.alkemy.preaceleracion.dto.CiudadDTO;
import com.alkemy.preaceleracion.service.CiudadService;

@RestController
@RequestMapping("/ciudades")
public class CiudadRest {
	
	@Autowired
	CiudadService ciudadService;

	@GetMapping
	public ResponseEntity<List<CiudadDTO>> listCiudades(
			@RequestParam(value = "denominacion", required = false) Optional<String> denominacion,
			@RequestParam(value = "continente", required = false) Optional<String> continente,
			@RequestParam(value = "order", required = false) Optional<String> order) {
		Map<String, String> queryParam = buildQueryMap(denominacion, continente, order);
		List<CiudadDTO> result = ciudadService.searchCiudad(queryParam);
		return ResponseEntity.ok(result);
	}

	@PostMapping
	public ResponseEntity<CiudadDTO> createCiudad(@RequestBody CiudadDTO ciudad) {
		if (ciudadService.createCiudad(ciudad)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(ciudad);
		}
		return ResponseEntity.status(400).body(ciudad);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CiudadDTO> updateCiudad(@PathParam("id") Long id,
			@RequestBody CiudadDTO ciudad) {
		if (ciudadService.updateCiudad(id, ciudad)) {
			return ResponseEntity.ok(ciudad);
		}
		return ResponseEntity.status(400).body(ciudad);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCiudad(@PathParam("id") Long id) {
		if (ciudadService.deleteCiudad(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(400).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<CiudadDTO> getCiudad(@PathParam("id") Long id) {
		CiudadDTO ciudad = ciudadService.getCiudad(id);
		return ResponseEntity.ok(ciudad);
	}

	private Map<String, String> buildQueryMap(Optional<String> oDenominacion, Optional<String> oContinente,
			Optional<String> oOrder) {
		Map<String, String> queryParam = new HashMap<>();
		oDenominacion.ifPresent(denominacion -> queryParam.put("denominacion", denominacion));
		oContinente.ifPresent(continente -> queryParam.put("continente", continente));
		oOrder.ifPresent(order -> queryParam.put("order", order));
		return queryParam;
	}

}
