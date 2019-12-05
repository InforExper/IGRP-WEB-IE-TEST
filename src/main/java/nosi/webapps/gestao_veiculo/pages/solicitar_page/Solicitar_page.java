package nosi.webapps.gestao_veiculo.pages.solicitar_page;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

public class Solicitar_page extends Model{		

	@RParam(rParamName = "p_nome")
	private String nome;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}



}
