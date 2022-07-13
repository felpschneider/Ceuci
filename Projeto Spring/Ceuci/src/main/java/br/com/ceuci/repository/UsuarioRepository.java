package br.com.ceuci.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ceuci.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
	
	public Optional<Usuario> findByUsuario(String usuario);

}