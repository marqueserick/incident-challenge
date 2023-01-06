package com.marqueserick.incidentApi.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel("Partial Incident")
public class IncidentPartialDto {
	
	@NotNull @NotBlank
	private String name;
	
	@NotNull @NotBlank
	private String description;
	
}
