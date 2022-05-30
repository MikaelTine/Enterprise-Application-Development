package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TECNICO")
@SequenceGenerator(name="tecnico", sequenceName = "SQ_TB_TECNICO", allocationSize = 1)
public class Tecnico {

	@Id
	@Column(name="cd_tecnico")
	@GeneratedValue(generator = "tecnico", strategy = GenerationType.SEQUENCE)
	private Integer codigo;
	
	//Relacionamento 1:1 - Bidirecional
	//mappedBy -> nome do atributo que mapeia a relação
	@OneToOne(mappedBy = "tecnico")
	private Time time;
	
	@Column(name="nm_tecnico", nullable = false, length = 80)
	private String nome;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;

	@Column(name="vl_salario", nullable = false, precision = 10, scale = 2)
	private BigDecimal salario;
	
	public Tecnico() {}
	
	public Tecnico(String nome, LocalDate dataNascimento, BigDecimal salario) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.salario = salario;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
