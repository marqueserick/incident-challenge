package com.marqueserick.incidentApi.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marqueserick.incidentApi.model.Incident;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentDto {
	
	private Long idIncident;
	private String name;
	private String description;
	
	@JsonFormat(pattern = "MM/dd/YYYY HH:mm:ss a Z")
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "MM/dd/YYYY HH:mm:ss a Z")
	private LocalDateTime updatedAt;
	
	@JsonFormat(pattern = "MM/dd/YYYY HH:mm:ss a Z")
	private LocalDateTime closedAt;
	
	public IncidentDto(Incident incident) {
		
		this.idIncident = incident.getIdIncident();
		this.name = incident.getName();
		this.description = incident.getDescription();
		this.createdAt = incident.getCreatedAt();
		this.updatedAt = incident.getUpdatedAt();
		this.closedAt = incident.getClosedAt();
	}
}
