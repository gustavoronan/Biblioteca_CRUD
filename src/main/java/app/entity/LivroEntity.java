package app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LivroEntity {
	int idLivro;
	String issn;
	String titulo;
	String sinopse;
	int ano;
	int num_pag;
	
}
