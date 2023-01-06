package com.marqueserick.incidentApi.controller.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marqueserick.incidentApi.model.Incident;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("Incident")
public class IncidentDto {
	
	private Long idIncident;
	private String name;
	private String description;
	
	@JsonFormat(pattern = "MM/dd/YYYY HH:mm:ss")
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "MM/dd/YYYY HH:mm:ss")
	private LocalDateTime updatedAt;
	
	@JsonFormat(pattern = "MM/dd/YYYY HH:mm:ss")
	private LocalDateTime closedAt;
	
	public IncidentDto(Incident incident) {
		
		this.idIncident = incident.getIdIncident();
		this.name = incident.getName();
		this.description = incident.getDescription();
		this.createdAt = incident.getCreatedAt();
		this.updatedAt = incident.getUpdatedAt();
		this.closedAt = incident.getClosedAt();
	}
	
	public IncidentDto(IncidentPartialDto create) {
		this.name = create.getName();
		this.description = create.getDescription();
		this.createdAt = LocalDateTime.now();
	}
}
