package nosi.webapps.gestao_veiculo.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * ati88
 * 18/11/2019
 * Class que representa a tabela veiculos na BD.
 */
@Entity
@Table(name="veiculos")
public class Veiculo extends BaseActiveRecord<Veiculo> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length=8)
	private String matricula;
	
	@Column(nullable = false, length=30)
	private String cor;

	@Column(nullable = false, length = 100)
	private String marca;
	
	
//	@OneToMany(mappedBy = "veiculo", fetch = FetchType.EAGER)
//	@JsonIgnore
//	private Set<Movimento> movimentos;
	
	/***
	 * Construtor da Class Veiculo, sem parametros.
	 */
	public Veiculo() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

//	@XmlTransient
//	public Set<Movimento> getMovimentos() {
//		return movimentos;
//	}
//
//	public void setMovimentos(Set<Movimento> movimentos) {
//		this.movimentos = movimentos;
//	}
	
}
