package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CAMPEONATO")
@SequenceGenerator(name="campeonato", sequenceName = "SQ_TB_CAMPEONATO", allocationSize = 1)
public class Campeonato {

	@Id
	@Column(name="cd_campeonato")
	@GeneratedValue(generator = "campeonato", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	//Relacionamento N:M bidirecional
	@ManyToMany(mappedBy = "campeonatos")
	private List<Time> times;
	
	@Column(name="nm_campeonato", nullable = false, length = 50)
	private String nome;
	
	@Column(name="vl_premiacao", precision = 10, scale = 2, nullable = false)
	private BigDecimal premiacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_tipo", length = 10)
	private TipoCampeonato tipo;
	
	@Column(name="nr_ano")
	private Integer ano;
	
	public Campeonato() {}

	public Campeonato(String nome, BigDecimal premiacao, TipoCampeonato tipo, Integer ano) {
		super();
		this.nome = nome;
		this.premiacao = premiacao;
		this.tipo = tipo;
		this.ano = ano;
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

	public BigDecimal getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(BigDecimal premiacao) {
		this.premiacao = premiacao;
	}

	public TipoCampeonato getTipo() {
		return tipo;
	}

	public void setTipo(TipoCampeonato tipo) {
		this.tipo = tipo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
}
