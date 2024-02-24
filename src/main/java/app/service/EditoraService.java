package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import app.entity.EditoraEntity;

@Service
public class EditoraService {

List<EditoraEntity> lista = new ArrayList<>();
	
	public String save (EditoraEntity editora) {
		lista.add(editora);
		return editora.getNomeEditora() + " editora salvo com sucesso";
	}
	
	public List<EditoraEntity> listAll(){

		EditoraEntity editora = new EditoraEntity(1, "livros", "rua 1", "0102301203");
		EditoraEntity editora2 = new EditoraEntity(2, "machados", "rua 2", "123912399123");
		EditoraEntity editora3 = new EditoraEntity(3, "darkside", "rua 3", "129394941231");

		lista.add(editora);
		lista.add(editora2);
		lista.add(editora3);

		return lista;

	}
	
	public EditoraEntity findById(long idEditora) {

		// banco de dados
		lista = this.listAll();

		if(lista != null)
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getIdEditora() == idEditora) {
					return lista.get(i);
				}
			}

		return null;
	
	}
	
	public String update(long idEditora, EditoraEntity editora) {
		
		lista = this.listAll();

		if(lista != null)
			for(int i=0; i<lista.size(); i++) {
				if(lista.get(i).getIdEditora() == idEditora) {
					lista.set(i, editora);
					return editora.getNomeEditora()+ " editora alterada com sucesso";
				}
			}

		return "não encontrado";
	}
	
	public boolean delete(long idEditora) {

		// banco de dados
		lista = this.listAll();

		if(lista != null)
			for(EditoraEntity editora : this.lista) {
				if(editora.getIdEditora() == idEditora) {
					this.lista.remove(editora);
					return true;
				}
			}

		return false;

	}
	
}
