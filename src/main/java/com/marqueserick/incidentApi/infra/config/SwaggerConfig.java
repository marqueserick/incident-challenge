package com.marqueserick.incidentApi.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.basePackage("com.marqueserick.incidentApi"))
		          .paths(PathSelectors.ant("/**"))
		          .build()
		          .apiInfo(getApiInfo());
	}
	
	public ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("IncidentAPI")
				.description("API built as solution for Java Developer Challenge")
				.version("1.0.0")
				.contact(new Contact("Erick Marques","https://linkedin.com/in/marqueserick","erickmarques43@gmail.com"))
				.build();
	}

}
