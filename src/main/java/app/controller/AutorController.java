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

import app.entity.AutorEntity;
import app.service.AutorService;



@RestController
@RequestMapping("/api/autor")

public class AutorController {
	
	@Autowired
	private AutorService autorService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody AutorEntity autor){



		try {

			String mensagem = this.autorService.save(autor);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);


		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<AutorEntity>> listAll (){
		
		try {
			
			List<AutorEntity> lista = this.autorService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findById/{idAutor}")
	public ResponseEntity<AutorEntity> findById(@PathVariable long idAutor){
		
		try {
			
			AutorEntity autor = this.autorService.findById(idAutor);
			return new ResponseEntity<>(autor, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("update/{idAutor}")
	public ResponseEntity<String> update(@RequestBody AutorEntity autor, @PathVariable long idAutor){



		try {

			String mensagem = this.autorService.update(idAutor, autor);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);


		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	@DeleteMapping("/delete/{idAutor}")
	public ResponseEntity<String> delete(@PathVariable long idAutor){
		
		try {
			
			if (this.autorService.delete(idAutor)) {
				return new ResponseEntity<String>("Apagado com sucesso", HttpStatus.OK);
				}else 
					return new ResponseEntity<String>("Nao encontrado", HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
