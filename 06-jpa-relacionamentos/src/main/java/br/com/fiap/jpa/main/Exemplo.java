package br.com.fiap.jpa.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.TecnicoDao;
import br.com.fiap.jpa.dao.TimeDao;
import br.com.fiap.jpa.dao.impl.TecnicoDaoImpl;
import br.com.fiap.jpa.dao.impl.TimeDaoImpl;
import br.com.fiap.jpa.entity.Campeonato;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Posicao;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.jpa.entity.TipoCampeonato;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Exemplo {

	//Cadastrar o tecnico e time
	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		try {
			//Cadastrar o tecnico
			//Instanciar um técnico, sem o código e time (criar o construtor)
			Tecnico tecnico = new Tecnico("Vitor", LocalDate.of(1980, 1, 1), new BigDecimal("150000"));
			//Instanciar o TecnicoDao
			TecnicoDao tecnicoDao = new TecnicoDaoImpl(em);
			//Cadastrar e commit;
			//tecnicoDao.cadastrar(tecnico);
			//tecnicoDao.commit();
			
			//Cadastrar um time			
			//Instanciar um time, sem o código (criar o construtor)
			Time time = new Time(tecnico, "Noroeste", "Alfredo de castilho");

			//Instanciar dois jogadores com nome, posição e número
			Jogador jogador = new Jogador("Joselito", Posicao.ATACANTE, 9);
			Jogador jogador2 = new Jogador("Marcelito",Posicao.GOLEIRO, 1);
			
			//Adicionar os jogadores no time
			time.addJogador(jogador);
			time.addJogador(jogador2);
			
			//Cadastrar campeonatos
			//Instanciar dois campeonatos com nome, premiação, tipo e ano
			Campeonato paulista = 
					new Campeonato("Paulista", new BigDecimal("10000"),TipoCampeonato.ESTADUAL, 2022);
			Campeonato copa = 
					new Campeonato("Copa do Mundo", new BigDecimal("0"), TipoCampeonato.MUNDIAL, 2022);
			
			//Criar uma lista de campeonatos
			List<Campeonato> campeonatos = new ArrayList<Campeonato>();
			
			//Adicionar os campeonatos na lista
			campeonatos.add(copa);
			campeonatos.add(paulista);
			
			//Setar a lista de campeonatos no time
			time.setCampeonatos(campeonatos);
			
			//Instanciar o TimeDao
			TimeDao timeDao = new TimeDaoImpl(em);
			//Cadastrar e commit
			timeDao.cadastrar(time);
			timeDao.commit();
			
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		em.close();
		fabrica.close();
	}
	
}
