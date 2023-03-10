package com.marqueserick.incidentApi.controller;

import java.util.List;

import javax.validation.Valid;

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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("incident")
@Api(tags="Incident Operations")
public class IncidentController {
	
	@Autowired
	private IncidentService service;
	
	@GetMapping
	@ApiOperation("List all incidents")
	public ResponseEntity<List<IncidentDto>> listAll(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@PostMapping
	@ApiOperation("Create a new incident")
	public ResponseEntity<IncidentDto> createIncident(@Valid @RequestBody IncidentPartialDto dto) {
		return ResponseEntity.ok(service.createIncident(dto));
	}
	
	@PutMapping("/{idIncident}")
	@ApiOperation("Update an incident by Id")
	public ResponseEntity<IncidentDto> updateIncident(@RequestBody IncidentPartialDto dto, @PathVariable("idIncident") Long id){
		IncidentDto incidentDto = service.updateIncident(dto, id);
		return ResponseEntity.ok(incidentDto);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation("Delete an incident by Id")
	public ResponseEntity<IncidentDto> deleteIncident(@PathVariable("id") Long id){
		service.deleteIncident(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	@ApiOperation("List an incident by Id")
	public ResponseEntity<IncidentDto> listIncidentById(@PathVariable("id") Long id){
		return ResponseEntity.ok(service.listById(id));
	}
	
	@GetMapping("/latest")
	@ApiOperation("List the 20 latest incidents")
	public ResponseEntity<List<IncidentDto>> latestIncidents(){
		return ResponseEntity.ok(service.listLatest());
	}

}
