package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.BibliotecaEntity;
import app.entity.Carro;
import app.service.BibliotecaService;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaService bibliotecaService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody BibliotecaEntity biblioteca){



		try {

			String mensagem = this.bibliotecaService.save(biblioteca);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);




		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	@PutMapping("update/{idBiblioteca}")
	public ResponseEntity<String> save(@RequestBody BibliotecaEntity biblioteca, @PathVariable long idBiblioteca){



		try {

			String mensagem = this.bibliotecaService.update(idBiblioteca, biblioteca);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);




		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	
	@GetMapping("/listAll")
	public ResponseEntity<List<BibliotecaEntity>> listAll (){
		
		try {
			
			List<BibliotecaEntity> lista = this.bibliotecaService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	
	@GetMapping("/findById/{idBiblioteca}")
	public ResponseEntity<BibliotecaEntity> findById(@PathVariable long idBiblioteca){
		
		try {
			
			BibliotecaEntity biblioteca = this.bibliotecaService.findById(idBiblioteca);
			return new ResponseEntity<>(biblioteca, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}

}

