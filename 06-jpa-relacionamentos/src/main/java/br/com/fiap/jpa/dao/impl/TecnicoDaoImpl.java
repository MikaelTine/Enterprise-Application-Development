package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TecnicoDao;
import br.com.fiap.jpa.entity.Tecnico;

public class TecnicoDaoImpl extends GenericDaoImpl<Tecnico, Integer> implements TecnicoDao {

	public TecnicoDaoImpl(EntityManager em) {
		super(em);
	}

}
