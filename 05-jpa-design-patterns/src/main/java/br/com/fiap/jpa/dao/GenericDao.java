package br.com.fiap.jpa.dao;

import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;

// GenericDao<Produto,Integer>
//T -> define a classe
//K -> tipo da chave primária

public interface GenericDao<T, K> {

	void cadastrar(T entidade);
	
	void atualizar(T entidade);
	
	void remover(K id) throws IdNotFoundException;
	
	T pesquisar(K id) throws IdNotFoundException;
	
	void commit() throws CommitException;
	
}