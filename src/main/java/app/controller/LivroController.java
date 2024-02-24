package app.controller;

import java.util.List;

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

import app.entity.LivroEntity;
import app.service.LivroService;

@RestController
@RequestMapping("/api/livro")

public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody LivroEntity livro){



		try {

			String mensagem = this.livroService.save(livro);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);


		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	@PutMapping("update/{idLivro}")
	public ResponseEntity<String> update(@RequestBody LivroEntity livro, @PathVariable long idLivro){



		try {

			String mensagem = this.livroService.update(idLivro, livro);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);


		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	
	@GetMapping("/listAll")
	public ResponseEntity<List<LivroEntity>> listAll (){
		
		try {
			
			List<LivroEntity> lista = this.livroService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	
	@GetMapping("/findById/{idLivro}")
	public ResponseEntity<LivroEntity> findById(@PathVariable long idLivro){
		
		try {
			
			LivroEntity livro = this.livroService.findById(idLivro);
			return new ResponseEntity<>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{idLivro}")
	public ResponseEntity<String> delete(@PathVariable long idLivro){
		
		try {
			
			if (this.livroService.delete(idLivro)) {
				return new ResponseEntity<String>("Apagado com sucesso", HttpStatus.OK);
				}else 
					return new ResponseEntity<String>("Nao encontrado", HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
