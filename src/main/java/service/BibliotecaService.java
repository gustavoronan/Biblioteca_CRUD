package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import entity.BibliotecaEntity;


@Service
public class BibliotecaService {

	List<BibliotecaEntity> lista = new ArrayList<>();
	
	public String save (BibliotecaEntity biblioteca) {
		lista.add(biblioteca);
		return biblioteca.getNome() + " salva com sucesso";
	}
	
}
