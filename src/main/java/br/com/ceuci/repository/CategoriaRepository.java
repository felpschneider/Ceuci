package br.com.ceuci.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ceuci.model.Categoria;

	@Repository
	public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
		public List<Categoria> findAllByTipoContainingIgnoreCase (String tipo);
		
}
