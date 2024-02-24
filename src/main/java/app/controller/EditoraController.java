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

import app.entity.EditoraEntity;
import app.service.EditoraService;



@RestController
@RequestMapping("/api/editora")

public class EditoraController {

	@Autowired
	private EditoraService editoraService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody EditoraEntity editora){



		try {

			String mensagem = this.editoraService.save(editora);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);


		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	@GetMapping("/listAll")
	public ResponseEntity<List<EditoraEntity>> listAll (){
		
		try {
			
			List<EditoraEntity> lista = this.editoraService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.CREATED);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@GetMapping("/findById/{idEditora}")
	public ResponseEntity<EditoraEntity> findById(@PathVariable long idEditora){
		
		try {
			
			EditoraEntity editora = this.editoraService.findById(idEditora);
			return new ResponseEntity<>(editora, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("update/{idEditora}")
	public ResponseEntity<String> update(@RequestBody EditoraEntity editora, @PathVariable long idEditora){



		try {

			String mensagem = this.editoraService.update(idEditora, editora);
			return new ResponseEntity<String>(mensagem,HttpStatus.OK);


		} catch (Exception e) {

			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);

		}		
		
	}
	
	@DeleteMapping("/delete/{idEditora}")
	public ResponseEntity<String> delete(@PathVariable long idEditora){
		
		try {
			
			if (this.editoraService.delete(idEditora)) {
				return new ResponseEntity<String>("Apagado com sucesso", HttpStatus.OK);
				}else 
					return new ResponseEntity<String>("Nao encontrado", HttpStatus.NOT_FOUND);
			
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
}
