package br.com.fiap.apisecurity.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
public class Usuario implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String login;
	private String senha;
	private UserRole role;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (UserRole.ADMIN.equals(this.role)) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
				new SimpleGrantedAuthority("ROLE_USER"));
		} else {
			return List.of(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	@Override
	public String getPassword() {
		return "";
	}

	@Override
	public String getUsername() {
		return "";
	}
}