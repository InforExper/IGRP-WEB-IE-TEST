package nosi.webapps.gestao_veiculo.pages.qualificacao;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

import nosi.core.validator.constraints.*;

public class Qualificacao extends Model{		

	@NotNull()
	@RParam(rParamName = "p_aprovacao")
	private String aprovacao;

	@RParam(rParamName = "p_obs")
	private String obs;
	
	public void setAprovacao(String aprovacao){
		this.aprovacao = aprovacao;
	}
	public String getAprovacao(){
		return this.aprovacao;
	}
	
	public void setObs(String obs){
		this.obs = obs;
	}
	public String getObs(){
		return this.obs;
	}



}
