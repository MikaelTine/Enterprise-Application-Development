package br.com.fiap.jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="func", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {
	
	@Id
	@Column(name="cd_funcinario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func")
	private Integer codigo;

	@Column(name="vl_salario", nullable = false, scale = 2, precision = 10)
	private BigDecimal salario;
	
	@Column(name="nm_funcionario", nullable = false, length = 70)
	private String nome;
	
	@Column(name="dt_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name="ds_endereco", length = 60)
	private String endereco;
	
	@Column(name="dt_admissao")
	private LocalDate dataAdmissao;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero genero;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}