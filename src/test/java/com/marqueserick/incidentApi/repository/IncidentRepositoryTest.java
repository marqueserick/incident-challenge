package com.marqueserick.incidentApi.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.marqueserick.incidentApi.model.Incident;

@DataJpaTest
public class IncidentRepositoryTest {
	
	@Autowired
	IncidentRepository repository;
	
	@Test
	void shouldNotReturnIncidentWhenClosedAtIsNotNull() {
		Incident incident = repository.findById(1L).get();
		incident.setClosedAt(LocalDateTime.now());
		repository.save(incident);
		
		List<Incident> incidents = repository.listAll();
		
		Assertions.assertEquals(1, incidents.size());
		
		for(Incident i : incidents) {
			Assertions.assertNull(i.getClosedAt());
		}
	}
	
	@Test
	void shouldReturnThe20LatestIncidents() {
		for(int i=0; i<20; i++) {
			Incident incident = new Incident();
			incident.setName("name");
			incident.setDescription("description");
			repository.save(incident);
		}
		
		List<Incident> incidents = repository.listLatest(20);
		
		Assertions.assertEquals(20, incidents.size());
		Assertions.assertTrue(incidents.get(19).getIdIncident() != 1);
		Assertions.assertTrue(incidents.get(19).getIdIncident() != 2);
		
	}

}
