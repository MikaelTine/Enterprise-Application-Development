package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente,Integer> implements ClienteDao{

	public ClienteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Cliente> buscarPorParteNome(String nome) {
		return em.createQuery("from Cliente c where lower(c.nome) like lower(:n) order by c.nome", Cliente.class)
				.setParameter("n", "%"+nome+"%")
				.getResultList();
	}

	public List<Cliente> buscarPorEstado(String estado) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf = :u",Cliente.class)
				.setParameter("u", estado)
				.getResultList();
	}

	public List<Cliente> buscarPorNumeroDiasReserva(Integer dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :d", Cliente.class)
				.setParameter("d", dias)
				.setMaxResults(50) //maximo de 50 registros
				.getResultList();
	}

	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :n and "
				+ "c.endereco.cidade.nome like :c", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("c", "%" + cidade + "%")
				.getResultList();
	}

	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :e", Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}

	public Long contarPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf = :e", Long.class)
				.setParameter("e", estado)
				.getSingleResult();
	}

}
