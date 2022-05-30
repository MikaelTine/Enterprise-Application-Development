package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Campeonato;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.CampeonatoDao;

public class CampeonatoDaoImpl 
				extends GenericDaoImpl<Campeonato, Integer> implements CampeonatoDao{

	public CampeonatoDaoImpl(EntityManager em) {
		super(em);
	}

}
