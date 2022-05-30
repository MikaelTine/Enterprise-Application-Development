package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ReservaDao;
import br.com.fiap.entity.Reserva;

public class ReservaDaoImpl extends GenericDaoImpl<Reserva,Integer> implements ReservaDao {

	public ReservaDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Reserva> buscarPorCpf(String cpf) {
		return em.createNamedQuery("Reserva.porClienteCpf", Reserva.class)
				.setParameter("D", cpf)
				.getResultList();
	}

}
