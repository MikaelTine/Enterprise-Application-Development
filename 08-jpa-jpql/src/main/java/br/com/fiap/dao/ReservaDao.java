package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDao extends GenericDao<Reserva,Integer> {
	
	//Buscar reservas por cpf do cliente
	List<Reserva> buscarPorCpf(String cpf);

}