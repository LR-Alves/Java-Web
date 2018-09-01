package br.com.cartorio.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.cartorio.model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Long> {

}
