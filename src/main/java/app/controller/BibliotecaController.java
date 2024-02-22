package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.entity.BibliotecaEntity;
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

}


