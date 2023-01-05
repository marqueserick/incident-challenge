package com.marqueserick.incidentApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marqueserick.incidentApi.controller.dto.IncidentPartialDto;
import com.marqueserick.incidentApi.controller.dto.IncidentDto;
import com.marqueserick.incidentApi.model.Incident;
import com.marqueserick.incidentApi.repository.IncidentRepository;

@Service
public class IncidentService {
	
	@Autowired
	private IncidentRepository repository;
	
	public List<IncidentDto> listAll(){
		List<Incident> incidents = repository.findAll();
		return incidents.stream().map(IncidentDto::new).toList();
	}

	public IncidentDto createIncident(IncidentPartialDto createIncident) {
		IncidentDto dto = new IncidentDto(createIncident);
		Incident incident = new Incident(dto);
		repository.save(incident);
		return new IncidentDto(incident);
	}

	public IncidentDto updateIncident(IncidentPartialDto dto, Long id) {
		Optional<Incident> incidentOptional = repository.findById(id);
		if(incidentOptional.isEmpty()) return null;
		Incident incident = incidentOptional.get();
		incident.update(dto);
		return new IncidentDto(incident);
	}

}
