package nosi.webapps.gestao_compras.dao;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * ati88
 * 14/11/2019
 */
@Entity
@Table(name="tbl_compras")
public class Compra extends BaseActiveRecord<Compra> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private double quntity;

	private double price;
	
	@Column(length=100)
	private Date date_purchase;

	@Column(length=100)
	private Date date_created;

	@ManyToOne
	@JoinColumn(name="id_produto", insertable = false, updatable =  false)
	private Produto produto;
	private int id_produto;

	@ManyToOne
	@JoinColumn(name="id_loja", insertable = false, updatable =  false)
	private Loja loja;
	private int id_loja;
		
	public Compra() {
		
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public double getQuntity() {
		return quntity;
	}


	public void setQuntity(double quntity) {
		this.quntity = quntity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Date getDate_purchase() {
		return date_purchase;
	}


	public void setDate_purchase(Date date_purchase) {
		this.date_purchase = date_purchase;
	}


	public Date getDate_created() {
		return date_created;
	}


	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public Loja getLoja() {
		return loja;
	}


	public void setLoja(Loja loja) {
		this.loja = loja;
	}


	public int getId_produto() {
		return id_produto;
	}


	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}


	public int getId_loja() {
		return id_loja;
	}


	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}


	
}
