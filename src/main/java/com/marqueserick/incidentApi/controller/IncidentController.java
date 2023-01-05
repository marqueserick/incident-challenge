package com.marqueserick.incidentApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marqueserick.incidentApi.controller.dto.IncidentDto;
import com.marqueserick.incidentApi.service.IncidentService;

@RestController
@RequestMapping("incident")
public class IncidentController {
	
	@Autowired
	private IncidentService service;
	
	@GetMapping
	public List<IncidentDto> listAll(){
		return service.listAll();
	}

}
