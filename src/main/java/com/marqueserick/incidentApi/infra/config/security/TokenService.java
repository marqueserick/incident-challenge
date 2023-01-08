package com.marqueserick.incidentApi.infra.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class TokenService {
	
	@Value("${security.token.secret}")
	private String secret;
	
	private static final String ISSUER_TOKEN= "IncidentAPI";
	
	public String generateToken(Authentication auth) {
		Algorithm algorithm = Algorithm.HMAC256(secret);
		return JWT.create()
				.withIssuer(ISSUER_TOKEN)
				.withSubject(auth.getName())
				.withExpiresAt(expirationDate())
				.sign(algorithm);
	}
	
	public String getUser(String token) {{
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer(ISSUER_TOKEN)
					.build()
					.verify(token)
					.getSubject();
		}
	}
	
	private Instant expirationDate() {
		return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
	}
}
