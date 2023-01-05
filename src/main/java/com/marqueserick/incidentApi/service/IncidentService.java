package com.marqueserick.incidentApi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

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
		List<Incident> incidents = repository.listAll();
		return incidents.stream().map(IncidentDto::new).collect(Collectors.toList());
	}

	public IncidentDto createIncident(IncidentPartialDto createIncident) {
		IncidentDto dto = new IncidentDto(createIncident);
		Incident incident = new Incident(dto);
		repository.save(incident);
		return new IncidentDto(incident);
	}

	public IncidentDto updateIncident(IncidentPartialDto dto, Long id) {
		Incident incident = getIncidentById(id);
		incident.update(dto);
		repository.save(incident);
		return new IncidentDto(incident);
	}

	public void deleteIncident(Long id) {
		Incident incident = getIncidentById(id);
		incident.delete();
		repository.save(incident);
	}
	
	public IncidentDto listById(Long id) {
		Incident incident = getIncidentById(id);
		return new IncidentDto(incident);
	}
	
	public List<IncidentDto> listLatest() {
		List<Incident> incidents = repository.listLatest(20);
		return incidents.stream().map(IncidentDto::new).collect(Collectors.toList());
	}
	
	private Incident getIncidentById(Long id) {
		Optional<Incident> incident = repository.findById(id);
		if(incident.isEmpty() || incident.get().getClosedAt() != null) throw new EntityNotFoundException();
		return incident.get();
	}

}
