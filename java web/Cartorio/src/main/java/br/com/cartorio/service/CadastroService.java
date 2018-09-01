package br.com.cartorio.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cartorio.model.Cadastro;
import br.com.cartorio.repository.CadastroRepository;

public class CadastroService {
	
	@Autowired
	private CadastroRepository repository;
	
	public Iterable<Cadastro> obterTodos(){
		
		Iterable<Cadastro> cadastrados = repository.findAll();
		
		return cadastrados;
		
	}
	
	
	public void salvar(Cadastro cadastro){
		repository.save(cadastro);
	}

}

	


