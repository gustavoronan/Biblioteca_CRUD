package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.BibliotecaEntity;


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

	
	
	
public String update(long idBiblioteca, BibliotecaEntity biblioteca) {
		
		lista = this.listAll();

		if(lista != null)
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getId() == idBiblioteca) {
					lista.set(i, biblioteca);
					return biblioteca.getNome()+ " biblioteca alterada com sucesso";
				}
			}

		return "não encontrado";
	}

public BibliotecaEntity findById(long idBiblioteca) {

	// banco de dados
	lista = this.listAll();

	if(lista != null)
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getId() == idBiblioteca) {
				return lista.get(i);
			}
		}

	return null;

}

public boolean delete(long idBiblioteca) {

	// banco de dados
	lista = this.listAll();

	if(lista != null)
		for(BibliotecaEntity biblioteca : this.lista) {
			if(biblioteca.getId() == idBiblioteca) {
				this.lista.remove(biblioteca);
				return true;
			}
		}

	return false;

}

	
	
}
