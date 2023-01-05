package com.marqueserick.incidentApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marqueserick.incidentApi.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

}
