package nosi.webapps.gestao_veiculo.dao.dto;

/**
 * ati88
 * 18/11/2019
 */

public class CondutorDto {
	private int id;
	private String nome;
	private String cni;
	private String carta_conducao;
/*
	@OneToMany(mappedBy = "condutor")
	private Set<Movimento> movimentos;
	*/
	public CondutorDto() { }

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
