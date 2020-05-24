package br.com.kriger.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.kriger.cursomc.domain.Categoria;
import br.com.kriger.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
		Optional<?> categoria = categoriaRepository.findById(id);
		return (Categoria) categoria.orElse(null);
	}

}
