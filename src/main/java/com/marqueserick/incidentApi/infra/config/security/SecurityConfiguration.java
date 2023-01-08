package com.marqueserick.incidentApi.infra.config.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.marqueserick.incidentApi.service.AuthenticationService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationService authService;
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception{
		return super.authenticationManager();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(authService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST,"/auth").permitAll()
				.antMatchers("/**.html").permitAll()
				.antMatchers("/v2/api-docs").permitAll()
				.antMatchers("/webjars/**").permitAll()
				.antMatchers("/configuration/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.anyRequest().authenticated().and()
				.csrf().disable()
				.exceptionHandling()
				.authenticationEntryPoint( (request, response, exception) ->{
					response.setContentType("text/plain");
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					response.getOutputStream().println("Token has expired or is not valid");
				})
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/h2-console/**");
	}
}
