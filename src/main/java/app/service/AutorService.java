package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.AutorEntity;

@Service
public class AutorService {

List<AutorEntity> lista = new ArrayList<>();
	
	public String save (AutorEntity autor) {
		lista.add(autor);
		return autor.getNomeAutor() + " autor salvo com sucesso";
	}
	
	public List<AutorEntity> listAll(){

		AutorEntity autor = new AutorEntity(1, "kleber", "1234000", 1899);
		AutorEntity autor2 = new AutorEntity(2, "machado", "123949123", 318);
		AutorEntity autor3 = new AutorEntity(3, "banban", "101010101283", 12);

		lista.add(autor);
		lista.add(autor2);
		lista.add(autor3);

		return lista;

	}
	
	public AutorEntity findById(long idAutor) {

		// banco de dados
		lista = this.listAll();

		if(lista != null)
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getIdAutor() == idAutor) {
					return lista.get(i);
				}
			}

		return null;
	
	}
	
	public String update(long idAutor, AutorEntity autor) {
		
		lista = this.listAll();

		if(lista != null)
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getIdAutor() == idAutor) {
					lista.set(i, autor);
					return autor.getNomeAutor()+ " autor alterado com sucesso";
				}
			}

		return "não encontrado";
	}
	
	public boolean delete(long idAutor) {

		// banco de dados
		lista = this.listAll();

		if(lista != null)
			for(AutorEntity autor : this.lista) {
				if(autor.getIdAutor() == idAutor) {
					this.lista.remove(autor);
					return true;
				}
			}

		return false;

	}
}
