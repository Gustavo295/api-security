package br.com.fiap.apisecurity.repository;

br com fiap apisecurity entity Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	UserDetails findByLogin(String login);
}
