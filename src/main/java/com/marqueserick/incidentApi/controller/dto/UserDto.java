package com.marqueserick.incidentApi.controller.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

@Getter
@ApiModel("User")
public class UserDto {
	
	private String username;
	private String passoword;

}
