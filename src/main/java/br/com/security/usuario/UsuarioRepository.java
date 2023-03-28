package br.com.security.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Users, Long> {

    UserDetails findByEmail(String login);
}
