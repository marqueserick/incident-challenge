package com.marqueserick.incidentApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marqueserick.incidentApi.controller.dto.UserDto;
import com.marqueserick.incidentApi.infra.config.security.TokenService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("auth")
@Api(tags="Auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	@ApiOperation("Generate a token to acess all endpoints")
	public ResponseEntity<String> authenticate(@RequestBody UserDto dto){
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassoword());
		Authentication authentication = authManager.authenticate(authToken);
		String token = tokenService.generateToken(authentication);
		return ResponseEntity.ok(token);
	}

}
