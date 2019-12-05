package nosi.webapps.store_app.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * ati88
 * 28/11/2019
 */
@Entity
@Table(name = "tbl_Item_requisicao")
public class ItemRequisicao extends BaseActiveRecord<ItemRequisicao> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String descricao;
	private int quantidade;
	
	@ManyToOne
	@JoinColumn(name = "requisicao_id", insertable = false, updatable = false)
	private Requisicao requisicao;
	private long requisicao_id;
	
	public ItemRequisicao() { }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Requisicao getRequisicao() {
		return requisicao;
	}

	public void setRequisicao(Requisicao requisicao) {
		this.requisicao = requisicao;
	}

	public long getRequisicao_id() {
		return requisicao_id;
	}

	public void setRequisicao_id(long requisicao_id) {
		this.requisicao_id = requisicao_id;
	}
	
}
