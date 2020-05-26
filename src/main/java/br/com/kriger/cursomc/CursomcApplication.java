package br.com.kriger.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.kriger.cursomc.domain.Categoria;
import br.com.kriger.cursomc.domain.Cidade;
import br.com.kriger.cursomc.domain.Estado;
import br.com.kriger.cursomc.domain.Produto;
import br.com.kriger.cursomc.repositories.CategoriaRepository;
import br.com.kriger.cursomc.repositories.CidadeRepository;
import br.com.kriger.cursomc.repositories.EstadoRepository;
import br.com.kriger.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria("Informática");
		Categoria categoria2 = new Categoria("Escritório");
		
		Produto produto1 = new Produto(null, "Computador", 2000.00);
		Produto produto2 = new Produto(null, "Impressora", 800.00);
		Produto produto3 = new Produto(null, "Mouse", 80.00);

		categoria1.setProdutos(Arrays.asList(produto1, produto2, produto3));
		categoria2.setProdutos(Arrays.asList(produto2));

		produto1.getCategorias().addAll(Arrays.asList(categoria1));
		produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria1));

		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		

		
		Estado estado1 = new Estado("Minas Gerais");
		Estado estado2 = new Estado("São Paulo");
		
		Cidade cidade1 = new Cidade("Uberlândia", estado1);
		Cidade cidade2 = new Cidade("São Paulo", estado2);
		Cidade cidade3 = new Cidade("Campinas", estado2);
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
	}

}
