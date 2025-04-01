package br.com.fiap.apisecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session ->
				session.sessionCreationPolicy.STATELESS))
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers(HttpMethod.GET, "/ususario").hasRole("ADMIN")
				.anyRequest().authenticated()
			)
			.build();
	}
}
