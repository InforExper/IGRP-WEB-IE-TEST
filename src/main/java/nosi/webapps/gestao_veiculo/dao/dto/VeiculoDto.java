package nosi.webapps.gestao_veiculo.dao.dto;

import java.io.Serializable;

/**
 * ati88
 * 18/11/2019
 * Class que representa a tabela veiculos na BD.
 */
public class VeiculoDto implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private int id;
	private String matricula;
	private String cor;
	private String marca;

//	private Set<Movimento> movimentos;
	
	public VeiculoDto() { }

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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
