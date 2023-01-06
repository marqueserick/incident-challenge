package com.marqueserick.incidentApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.marqueserick.incidentApi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<UserDetails> findByUsername(String username);

}
