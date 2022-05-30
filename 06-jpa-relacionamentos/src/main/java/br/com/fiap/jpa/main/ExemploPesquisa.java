package br.com.fiap.jpa.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Campeonato;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ExemploPesquisa {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Criar o TimeDao
		TimeDao dao = new TimeDaoImpl(em);
		
		try {
			//Pesquisar o time pela PK 
			Time time = dao.pesquisar(3);
			
			//Exibir o nome do time
			System.out.println(time.getNome());
	
			//Exibir o nome do técnico
			System.out.println(time.getTecnico().getNome());
			
			//Exibir o nome dos jogadores
			//Recuperar a lista de jogadoers do time
			List<Jogador> lista = time.getJogadores();
			//Percorrer a lista de jogadores e exibir o nome
			System.out.println("Jogadores:");
			for (Jogador jogador : lista) {
				System.out.println(jogador.getNome());
			}
			
			//Exibir os campeonatos do time
			System.err.println("Campeonatos:");
			for (Campeonato item : time.getCampeonatos()) {
				System.out.println(item.getNome());
			}
			
		}catch(IdNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}
}