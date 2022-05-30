package br.com.fiap.jpa.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.dao.DepartamentoDao;
import br.com.fiap.jpa.entity.Departamento;

public class DepartamentoDaoImpl
						extends GenericDaoImpl<Departamento, Integer>
												implements DepartamentoDao {

	public DepartamentoDaoImpl(EntityManager em) {
		super(em);
	}

}
