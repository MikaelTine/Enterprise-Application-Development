package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.entity.Funcionario;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

public interface FuncionarioDao {

	void cadastrar(Funcionario funcionario);
	
	void atualizar(Funcionario funcionario);
	
	void remover(Integer id) throws IdNotFoundException;
	
	Funcionario pesquisar(Integer id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}
