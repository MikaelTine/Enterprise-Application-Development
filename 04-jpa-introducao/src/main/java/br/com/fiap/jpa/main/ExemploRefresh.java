package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;

public class ExemploRefresh {
	
	public static void main(String[] args) {
		//Obter a fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();

		//Pesquisar o cliente pelo c�digo
		Cliente cliente = em.find(Cliente.class, 4);
		
		//Exibir o nome do cliente
		System.out.println(cliente.getNome());
		
		//Alterar o nome do cliente no objeto
		cliente.setNome("Gabriela");
		
		//Exibir o nome do cliente
		System.out.println(cliente.getNome());
		
		//Chamar o m�todo refresh
		em.refresh(cliente);
		
		//Exibir o nome do cliente
		System.out.println(cliente.getNome());
		
		//Fechar
		em.close();
		fabrica.close();
	}
}