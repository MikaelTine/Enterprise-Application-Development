package br.com.fiap.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TIME")
@SequenceGenerator(name="time", sequenceName = "SQ_TB_TIME", allocationSize = 1)
public class Time {

	@Id
	@Column(name="cd_time")
	@GeneratedValue(generator = "time", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	//Relacionamento N:M
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="TB_TIME_CAMPEONATO",
			joinColumns = @JoinColumn(name="cd_time"),
			inverseJoinColumns = @JoinColumn(name="cd_campeonato"))
	private List<Campeonato> campeonatos;
	
	//Relacionamento 1:1
	//cascade -> realiza a ação determinada em casacata (no relacionamento)
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@JoinColumn(name="cd_tecnico", nullable = false)
	private Tecnico tecnico;
	
	//Relacionamento 1:N (bidirecional)
	@OneToMany(mappedBy = "time", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Jogador> jogadores = new ArrayList<Jogador>();
	
	@Column(name="nm_time", nullable = false, length = 80)
	private String nome;
	
	@Column(name="nm_estadio", length = 80)
	private String estadio;
	
	public Time() {}

	public Time(Tecnico tecnico, String nome, String estadio) {
		super();
		this.tecnico = tecnico;
		this.nome = nome;
		this.estadio = estadio;
	}
	
	//Método para adicionar jogador, para garantir o preenchimento da FK
	public void addJogador(Jogador jogador) {
		//Setar a FK do Jogador (cd_time)
		jogador.setTime(this);
		//Adicionar o jogador na lista
		jogadores.add(jogador);
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}

	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	
}
