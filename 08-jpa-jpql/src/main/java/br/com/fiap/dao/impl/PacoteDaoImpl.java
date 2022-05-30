package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDao;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDaoImpl extends GenericDaoImpl<Pacote,Integer> implements PacoteDao{

	public PacoteDaoImpl(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Pacote> listar() {
		//Criar a query
		TypedQuery<Pacote> query = em.createQuery("from Pacote", Pacote.class);
		//Executar a query
		return query.getResultList();
	}

	public List<Pacote> buscarPorPrecoMaior(Float preco) {
		//Criar a query
		TypedQuery<Pacote> query =
			em.createQuery("from Pacote p where p.preco > :churros",Pacote.class);
		//Setar o parâmetro na query
		query.setParameter("churros", preco);
		//Executar a query
		return query.getResultList();
	}

	public List<Pacote> buscarPorTransporte(Transporte transporte) {
		return em.createQuery("from Pacote p where p.transporte = :t", Pacote.class)
				.setParameter("t", transporte)
				.getResultList();
	}

	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) {
		return em.createQuery("from Pacote p where p.dataSaida between :i and :f", Pacote.class)
				.setParameter("i", inicio)
				.setParameter("f", fim)
				.getResultList();
	}

	public double somarPrecosPorTransporte(Transporte transporte) {		
		return em.createQuery("select sum(p.preco) from Pacote p where p.transporte = :t", Double.class)
				.setParameter("t", transporte)
				.getSingleResult();
	}

	//Pesquisar com a query nativa do oracle
	@SuppressWarnings("unchecked")
	public List<Pacote> buscarPorPrecoMenor(Float preco) {
		return em.createNativeQuery("select * from tb_ead_pacote where vl_pacote <= :p", Pacote.class)
				.setParameter("p", preco)
				.getResultList();
	}

}
