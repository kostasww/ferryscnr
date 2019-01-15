package com.kostasvr.geoNamesProject;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Value("${credentials.username}")
	private String username;
    @Value("${credentials.password}")
	private String pass;
    
	// Authentication : User --> Roles
	protected void configure(AuthenticationManagerBuilder auth)

			throws Exception {

		auth.inMemoryAuthentication().withUser(username).password("{noop}"+pass)
		.roles("USER");
				
	}

	// Authorization : Role -> Access
	protected void configure(HttpSecurity http) throws Exception {

		http.httpBasic().and().authorizeRequests().antMatchers("/getBoundingBox/??","/getWeather/??")

		.hasRole("USER").and()

		.csrf().disable().headers().frameOptions().disable();

	}

}