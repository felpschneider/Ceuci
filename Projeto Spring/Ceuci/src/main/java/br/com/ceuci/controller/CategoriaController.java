package br.com.ceuci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ceuci.model.CategoriaModel;
import br.com.ceuci.repository.CategoriaRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<CategoriaModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CategoriaModel>> getByTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(repository.findAllByTipoContainingIgnoreCase(tipo));
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> post (@RequestBody CategoriaModel categoria) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> put (@RequestBody CategoriaModel categoria) {
		return ResponseEntity.ok(repository.save(categoria));
	
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
