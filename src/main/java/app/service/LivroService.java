package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.LivroEntity;

@Service
public class LivroService {


	List<LivroEntity> lista = new ArrayList<>();
	
	public String save (LivroEntity livro) {
		lista.add(livro);
		return livro.getTitulo() + " livro salvo com sucesso";
	}
	
	

	public List<LivroEntity> listAll(){

		LivroEntity livro = new LivroEntity(1, "12345678", "Dom Casmurro", "Um clássico da literatura brasileira", 1899, 256);
		LivroEntity livro2 = new LivroEntity(2, "98765432", "A Culpa é das Estrelas", "Uma história emocionante sobre amor e perda", 2012, 318);
		LivroEntity livro3 = new LivroEntity(3, "13579246", "Harry Potter e a Pedra Filosofal", "O primeiro livro da saga Harry Potter", 1997, 223);

		lista.add(livro);
		lista.add(livro2);
		lista.add(livro3);

		return lista;

	}

	
	
	
public String update(long idLivro, LivroEntity livro) {
		
		lista = this.listAll();

		if(lista != null)
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getIdLivro() == idLivro) {
					lista.set(i, livro);
					return livro.getTitulo()+ " livro alterada com sucesso";
				}
			}

		return "não encontrado";
	}

public LivroEntity findById(long idLivro) {

	// banco de dados
	lista = this.listAll();

	if(lista != null)
		for(int i=0; i<lista.size(); i++) {
			if(lista.get(i).getIdLivro() == idLivro) {
				return lista.get(i);
			}
		}

	return null;

}

public boolean delete(long idLivro) {

	// banco de dados
	lista = this.listAll();

	if(lista != null)
		for(LivroEntity livro : this.lista) {
			if(livro.getIdLivro() == idLivro) {
				this.lista.remove(livro);
				return true;
			}
		}

	return false;

}
	
}
