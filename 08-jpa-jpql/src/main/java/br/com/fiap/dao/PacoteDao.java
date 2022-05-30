package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDao extends GenericDao<Pacote,Integer>{
	
	List<Pacote> listar();
	
	//Buscar pacote por preço maior
	List<Pacote> buscarPorPrecoMaior(Float preco);

	//3-Buscar por transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);
	
	//6-Buscar por data de saída
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
	double somarPrecosPorTransporte(Transporte transporte);
	
	List<Pacote> buscarPorPrecoMenor(Float preco);
	
}
