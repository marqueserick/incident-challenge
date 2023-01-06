package com.marqueserick.incidentApi.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class IncidentPartialDto {
	
	@NotNull @NotBlank
	private String name;
	
	@NotNull @NotBlank
	private String description;
	
}
