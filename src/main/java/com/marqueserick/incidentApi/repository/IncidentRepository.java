package com.marqueserick.incidentApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marqueserick.incidentApi.model.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
	
	@Query("SELECT i FROM Incident i WHERE i.closedAt = null")
	List<Incident> listAll();

	@Query(value = "SELECT TOP ?1 * FROM Incident WHERE closed_at is null ORDER BY created_at DESC", nativeQuery = true)
	List<Incident> listLatest(int max);

}
