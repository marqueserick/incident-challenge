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
		List<Incident> incidents = repository.listAll();
		return incidents.stream().map(IncidentDto::new).toList();
	}

	public IncidentDto createIncident(IncidentPartialDto createIncident) {
		IncidentDto dto = new IncidentDto(createIncident);
		Incident incident = new Incident(dto);
		repository.save(incident);
		return new IncidentDto(incident);
	}

	public IncidentDto updateIncident(IncidentPartialDto dto, Long id) {
		Incident incident = getIncidentById(id);
		if(isIncidentUnavailable(incident)) return null;
		incident.update(dto);
		return new IncidentDto(incident);
	}

	public boolean deleteIncident(Long id) {
		Incident incident = getIncidentById(id);
		if(isIncidentUnavailable(incident)) return false;
		incident.delete();
		repository.save(incident);
		return true;
	}
	
	public IncidentDto listById(Long id) {
		Incident incident = getIncidentById(id);
		if(isIncidentUnavailable(incident)) return null;
		return new IncidentDto(incident);
	}
	
	private Incident getIncidentById(Long id) {
		Optional<Incident> incident = repository.findById(id);
		if(incident.isEmpty()) return null;
		return incident.get();
	}
	
	private boolean isIncidentUnavailable(Incident incident) {
		return incident == null || incident.getClosedAt() != null;
	}

}
