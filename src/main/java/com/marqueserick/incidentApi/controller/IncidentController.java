package com.marqueserick.incidentApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marqueserick.incidentApi.controller.dto.IncidentPartialDto;
import com.marqueserick.incidentApi.controller.dto.IncidentDto;
import com.marqueserick.incidentApi.service.IncidentService;

@RestController
@RequestMapping("incident")
public class IncidentController {
	
	@Autowired
	private IncidentService service;
	
	@GetMapping
	public ResponseEntity<List<IncidentDto>> listAll(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@PostMapping
	public ResponseEntity<IncidentDto> createIncident(@RequestBody IncidentPartialDto dto) {
		return ResponseEntity.ok(service.createIncident(dto));
	}
	
	@PutMapping("/{idIncident}")
	public ResponseEntity<IncidentDto> updateIncident(@RequestBody IncidentPartialDto dto, @PathVariable("idIncident") Long id){
		IncidentDto incidentDto = service.updateIncident(dto, id);
		if(incidentDto == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(incidentDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<IncidentDto> deleteIncident(@PathVariable("id") Long id){
		if(service.deleteIncident(id)) return ResponseEntity.noContent().build();
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<IncidentDto> listIncidentById(@PathVariable("id") Long id){
		IncidentDto incidentDto = service.listById(id);
		if(incidentDto == null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(incidentDto);
	}

}
