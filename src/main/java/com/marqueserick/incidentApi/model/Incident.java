package com.marqueserick.incidentApi.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.marqueserick.incidentApi.controller.dto.IncidentDto;
import com.marqueserick.incidentApi.controller.dto.IncidentPartialDto;
import com.marqueserick.incidentApi.infra.exception.FieldsToUpdateException;

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
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
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
		boolean isNameValid = isStringValid(dto.getName());
		boolean isDescriptionValid = isStringValid(dto.getDescription());
		boolean isUpdated = isNameValid || isDescriptionValid;
		
		if(isNameValid) this.name = dto.getName();
		
		if(isDescriptionValid) this.description = dto.getDescription();
		
		if(isUpdated) this.updatedAt = LocalDateTime.now();
		else throw new FieldsToUpdateException("Fields name or description should be informed");
		
	}

	public void delete() {
		this.closedAt = LocalDateTime.now();
	}
	
	private boolean isStringValid(String s) {
		return s != null
				&& !s.isEmpty()
				&& !s.isBlank();
	}

}
