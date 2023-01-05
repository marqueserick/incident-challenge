package com.marqueserick.incidentApi.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.marqueserick.incidentApi.controller.dto.IncidentDto;
import com.marqueserick.incidentApi.controller.dto.IncidentPartialDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="incident")
@Entity(name="Incident")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIncident;
	
	private String name;
	
	private String description;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;
	
	private LocalDateTime closedAt;
	
	public Incident(IncidentDto incident) {
		this.name = incident.getName();
		this.description = incident.getDescription();
		this.createdAt = incident.getCreatedAt();
	}

	public void update(IncidentPartialDto dto) {
		this.name = dto.getName();
		this.description = dto.getDescription();
		this.updatedAt = LocalDateTime.now();
		
	}

	public void delete() {
		this.closedAt = LocalDateTime.now();
	}

}
