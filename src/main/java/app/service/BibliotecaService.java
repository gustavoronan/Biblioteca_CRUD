package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.BibliotecaEntity;
import app.entity.Carro;


@Service
public class BibliotecaService {

	List<BibliotecaEntity> lista = new ArrayList<>();
	
	public String save (BibliotecaEntity biblioteca) {
		lista.add(biblioteca);
		return biblioteca.getNome() + " salva com sucesso";
	}
	
	

	public List<BibliotecaEntity> listAll(){

		BibliotecaEntity biblioteca = new BibliotecaEntity(1, "AAA", "BBB");
		BibliotecaEntity biblioteca2 = new BibliotecaEntity(2, "ABC", "BBB");
		BibliotecaEntity biblioteca3 = new BibliotecaEntity(3, "DDD", "BBB");

		lista.add(biblioteca);
		lista.add(biblioteca2);
		lista.add(biblioteca3);

		return lista;

	}

	
	
	public String update (long idBiblioteca, BibliotecaEntity biblioteca) {
		
		lista = this.listAll();
		
		if (lista!=null) {
			for (int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idBiblioteca) {
					lista.set(i, biblioteca);
					return biblioteca.getNome() + " alterado com sucesso";

				}
			}
			
		}else {
			
			return "biblioteca nao encontrada.";
		}
			
	}
	
	
}
