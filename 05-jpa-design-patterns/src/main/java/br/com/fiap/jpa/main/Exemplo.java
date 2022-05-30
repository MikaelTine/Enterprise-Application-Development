package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.DepartamentoDao;
import br.com.fiap.jpa.dao.GenericDao;
import br.com.fiap.jpa.dao.impl.DepartamentoDaoImpl;
import br.com.fiap.jpa.dao.impl.GenericDaoImpl;
import br.com.fiap.jpa.entity.Departamento;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	//Testar o DAO Genérico! 
	public static void main(String[] args) {
		//Obter uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Opção 1
		//Instanciar um DepartamentoDaoImpl
		//DepartamentoDao dao = new DepartamentoDaoImpl(em);
		
		//Opção 2
		GenericDao<Departamento, Integer> dao = 
				//Criando uma classe anônima e instanciando
				new GenericDaoImpl<Departamento, Integer>(em) {};
		
		//Instanciar um Departamento
		Departamento dep = new Departamento("TI"); //Criar os construtores!
		
		try {
			//Cadastrar um departamento
			dao.cadastrar(dep);
			dao.commit();
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar um departamento
			Departamento busca = dao.pesquisar(1);
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar um departamento
			dep.setNome("RH");
			dao.atualizar(dep);
			dao.commit();
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover um departamento
		try {
			dao.remover(1);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		fabrica.close();
	}
}
