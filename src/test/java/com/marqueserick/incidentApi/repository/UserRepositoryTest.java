package com.marqueserick.incidentApi.repository;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import com.marqueserick.incidentApi.model.User;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	UserRepository repository;
	
	User user;
	
	@BeforeEach
	void init() {
		user = new User(1L,"admin","$2a$12$6DOxiW2bNhuBxu27XKiVHOtlQRRSblFUqL1uepagrsrNu/A0TOU42");	
	}
	
	@Test
	void shouldReturnUser() {
		Optional<UserDetails> optionalUser = repository.findByUsername(user.getUsername());
		User foundUser = (User) optionalUser.get();
		
		Assertions.assertNotNull(foundUser);
		Assertions.assertEquals(user.getUsername(),foundUser.getUsername());
		Assertions.assertEquals(user.getPassword(),foundUser.getPassword());
	}
	
	@Test
	void shouldNotReturnUser() {
		Optional<UserDetails> optionalUser = repository.findByUsername("!admin");
		Assertions.assertThrows(NoSuchElementException.class, () -> optionalUser.get());
	}

}
