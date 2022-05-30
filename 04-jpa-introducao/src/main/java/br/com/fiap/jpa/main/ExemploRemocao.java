package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Cliente;

public class ExemploRemocao {

	public static void main(String[] args) {
		//Obter a fabrica de entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		
		//Obter o entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Procurar o cliente
		Cliente cliente = em.find(Cliente.class, 3);
		
		//Chamar o método remove
		em.remove(cliente);
		
		//Commit
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println(cliente.getNome());
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
}
