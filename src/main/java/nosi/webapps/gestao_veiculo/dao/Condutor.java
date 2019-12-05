package nosi.webapps.gestao_veiculo.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * ati88
 * 18/11/2019
 */
@Entity
@Table(name="condutores")
public class Condutor extends BaseActiveRecord<Condutor> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, length=100)
	private String nome;
	
	@Column(nullable = false, length=20, unique=true)
	private String cni;

	@Column(nullable = false, length = 10, unique = true)
	private String carta_conducao;
/*
	@OneToMany(mappedBy = "condutor")
	private Set<Movimento> movimentos;
	*/
	public Condutor() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCni() {
		return cni;
	}

	public void setCni(String cni) {
		this.cni = cni;
	}

	public String getCarta_conducao() {
		return carta_conducao;
	}

	public void setCarta_conducao(String carta_conducao) {
		this.carta_conducao = carta_conducao;
	}
/*
	public Set<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(Set<Movimento> movimentos) {
		this.movimentos = movimentos;
	}*/
	
}
