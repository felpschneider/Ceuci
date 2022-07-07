package br.com.ceuci.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ceuci.model.CategoriaModel;

	@Repository
	public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
		public List<CategoriaModel> findAllByHortaAndMerceariaAndMistoContainingIgnoreCase (String horta, String mercearia, String misto);
		
}
