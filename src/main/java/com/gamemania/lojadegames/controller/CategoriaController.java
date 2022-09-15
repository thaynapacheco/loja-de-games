package com.gamemania.lojadegames.controller;

import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamemania.lojadegames.model.CategoriaGame;
import com.gamemania.lojadegames.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
public class categoriaController {

	@Autowired
	private CategoriaRepository categoria;
	
	@GetMapping
	public ResponseEntity<List<CategoriaGame>> GetAll(){
		return ResponseEntity.ok(categoria.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaGame> GetById(@PathVariable long id){
		return categoria.findById(id)
				.map(response -> ResponseEntity.ok(response))
				.orElse(ResponseEntity.notFound().build());
	
	} 

	@GetMapping("/pagamento/{pagamento}")
	public ResponseEntity<List<CategoriaGame>> GetByPagamento(@PathVariable String Pagamento){
		return ResponseEntity.ok(categoria.findAllByPagamento(Pagamento));
	}

	@PostMapping
	public ResponseEntity<CategoriaGame> post(@RequestBody CategoriaGame categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(this.categoria.save(categoria));
	}

	@PutMapping
	public ResponseEntity<CategoriaGame> put(@RequestBody CategoriaGame categoria){
		return ResponseEntity.status(HttpStatus.OK).body(this.categoria.save(categoria));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		this.categoria.deleteById(id);
	}
}