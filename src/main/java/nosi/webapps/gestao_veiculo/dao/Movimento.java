package nosi.webapps.gestao_veiculo.dao;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * ati88
 * 18/11/2019
 */
@Entity
@Table(name = "movimentos")
public class Movimento extends BaseActiveRecord<Movimento> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double km_entrada;
	
	private double km_saida;

	private Timestamp data_saida;
	
	private Timestamp data_entrada;

//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "condutor_id", nullable = false, insertable = false, updatable = false)
//	private Condutor condutor;
//	private Integer condutor_id;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "veiculo_id", nullable = false, insertable = false, updatable = false)
//	private Veiculo veiculo;
//	private Integer veiculo_id;
	
	public Movimento() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getKm_entrada() {
		return km_entrada;
	}

	public void setKm_entrada(double km_entrada) {
		this.km_entrada = km_entrada;
	}

	public double getKm_saida() {
		return km_saida;
	}

	public void setKm_saida(double km_saida) {
		this.km_saida = km_saida;
	}

	public Timestamp getData_saida() {
		return data_saida;
	}

	public void setData_saida(Timestamp data_saida) {
		this.data_saida = data_saida;
	}

	public Timestamp getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Timestamp data_entrada) {
		this.data_entrada = data_entrada;
	}
//
//	public Condutor getCondutor() {
//		return condutor;
//	}
//
//	public void setCondutor(Condutor condutor) {
//		this.condutor = condutor;
//	}
//
//	public Integer getCondutor_id() {
//		return condutor_id;
//	}
//
//	public void setCondutor_id(Integer condutor_id) {
//		this.condutor_id = condutor_id;
//	}
//
//	public Veiculo getVeiculo() {
//		return veiculo;
//	}
//
//	public void setVeiculo(Veiculo veiculo) {
//		this.veiculo = veiculo;
//	}
//
//	public Integer getVeiculo_id() {
//		return veiculo_id;
//	}
//
//	public void setVeiculo_id(Integer veiculo_id) {
//		this.veiculo_id = veiculo_id;
//	}
	
}
