package br.fiap.com.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.ClienteDao;
import br.com.fiap.dao.PacoteDao;
import br.com.fiap.dao.TransporteDao;
import br.com.fiap.dao.impl.ClienteDaoImpl;
import br.com.fiap.dao.impl.PacoteDaoImpl;
import br.com.fiap.dao.impl.TransporteDaoImpl;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisas {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar o PacoteDao
		PacoteDao pacoteDao = new PacoteDaoImpl(em);
		
		//Pesquisar por todos os pacotes e armazenar em uma lista
		//List<Pacote> lista = pacoteDao.listar();
		List<Pacote> lista = pacoteDao.buscarPorPrecoMaior(2000f);
		
		//Percorrer a lista de pacotes e exibir a descrição dos pacotes
		for (Pacote item : lista) {
			System.out.println(item.getDescricao() + " " + item.getPreco());
		}
		
		//Listar todos os clientes
		//Instanciar o ClienteDao
		ClienteDao clienteDao = new ClienteDaoImpl(em);
		
		//Pesquisar por todos os clientes
		//List<Cliente> clientes = clienteDao.listar();
		List<Cliente> clientes = clienteDao.buscarPorParteNome("Le");
		
		//Exibir o nome dos clientes
		for (Cliente cliente: clientes) {
			System.out.println(cliente.getNome());
		}
		
		//Pesquisar os pacotes por um transporte
		//Instanciar um TransporteDao
		TransporteDao transporteDao = new TransporteDaoImpl(em);
		
		//Pesquisar um transporte por codigo
		Transporte transporte = transporteDao.pesquisar(1);
		
		//Pesquisar os pacotes pelo transporte
		lista = pacoteDao.buscarPorTransporte(transporte);
		
		//Exibir a descrição do pacote e o nome da empresa do transporte
		for (Pacote p : lista) {
			System.out.println(p.getDescricao() + 
					" " + p.getTransporte().getEmpresa());	
		}
		
		//Pesquisar os clientes por estado
		//clientes = clienteDao.buscarPorEstado("PR");
		//clientes = clienteDao.buscarPorNumeroDiasReserva(10);
		clientes = clienteDao.listar(2, 2);
		
		//Exibir o nome do cliente e o estado do cliente
		for (Cliente c : clientes) {
			System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf());
		}
		
		//Declarar as datas para a pesquisa dos pacotes
		Calendar inicio = new GregorianCalendar(2023, Calendar.JANUARY, 1);
		Calendar fim = new GregorianCalendar(2023, Calendar.AUGUST, 24);
		
		//Pesquisar os pacotes por intervalo de data
		lista = pacoteDao.buscarPorDatas(inicio, fim);
		
		//Exibir a descrição dos pacotes
		for (Pacote p : lista) {
			System.out.println(p.getDescricao());
		}
		
		//Pesquisar os clientes por parte do nome e parte do nome da cidade
		clientes = clienteDao.buscar("a", "Londrina");
		for (Cliente c : clientes) {
			System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getNome());
		}
		
		//Criar uma lista de strings
		List<String> estados = new ArrayList<String>();
		//Adicionar os estados (siglas) na lista
		estados.add("SP");
		estados.add("PR");
		
		//Pesquisar os clientes por estados
		clientes = clienteDao.buscarPorEstados(estados);
		
		//Exibir o nome dos clientes e o estado
		for (Cliente c : clientes) {
			System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf());
		}
		
	}//main
}//class
