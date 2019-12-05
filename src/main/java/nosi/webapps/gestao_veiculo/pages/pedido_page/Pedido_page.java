package nosi.webapps.gestao_veiculo.pages.pedido_page;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

public class Pedido_page extends Model{		

	@RParam(rParamName = "p_nome")
	private String nome;

	@RParam(rParamName = "p_obs_pedido")
	private String obs_pedido;

	@RParam(rParamName = "p_email")
	private String email;

	@RParam(rParamName = "p_telefone")
	private String telefone;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setObs_pedido(String obs_pedido){
		this.obs_pedido = obs_pedido;
	}
	public String getObs_pedido(){
		return this.obs_pedido;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setTelefone(String telefone){
		this.telefone = telefone;
	}
	public String getTelefone(){
		return this.telefone;
	}



}
