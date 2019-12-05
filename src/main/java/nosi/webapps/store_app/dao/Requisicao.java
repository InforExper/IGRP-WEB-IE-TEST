package nosi.webapps.store_app.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * ati88
 * 28/11/2019
 */
@Entity
@Table(name = "tbl_requisicao")
public class Requisicao extends BaseActiveRecord<Requisicao> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String justificacao;
	
	@Column(name = "data_requisicao")
	private Date dataRequisicao;
	
	private String estado;
	
	@OneToMany(mappedBy = "requisicao", fetch = FetchType.EAGER)
	private List<ItemRequisicao> itemRequisicoes;
	
	public Requisicao() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getJustificacao() {
		return justificacao;
	}

	public void setJustificacao(String justificacao) {
		this.justificacao = justificacao;
	}

	public Date getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(Date dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemRequisicao> getItemRequisicoes() {
		return itemRequisicoes;
	}

	public void setItemRequisicoes(List<ItemRequisicao> itemRequisicoes) {
		this.itemRequisicoes = itemRequisicoes;
	}

	@Override
	public String toString() {
		return "Requisicao [id=" + id + ", justificacao=" + justificacao + ", dataRequisicao=" + dataRequisicao
				+ ", estado=" + estado + "]";
	}
	
}
