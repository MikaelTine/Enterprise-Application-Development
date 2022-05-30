package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Time;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.TimeDao;

public class TimeDaoImpl extends GenericDaoImpl<Time, Integer> implements TimeDao{

	public TimeDaoImpl(EntityManager em) {
		super(em);
	}

}
