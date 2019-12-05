package nosi.webapps.gestao_veiculo.pages.registar_movimento;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

import nosi.core.validator.constraints.*;

public class Registar_movimento extends Model{		

	@RParam(rParamName = "p_header_text")
	private String header_text;

	@NotNull()
	@RParam(rParamName = "p_condutor")
	private String condutor;

	@NotNull()
	@RParam(rParamName = "p_veiculo")
	private String veiculo;

	@NotNull()
	@RParam(rParamName = "p_data_saida")
	private String data_saida;

	@RParam(rParamName = "p_hora")
	private String hora;

	@RParam(rParamName = "p_km_saida")
	private double km_saida;

	@NotNull()
	@RParam(rParamName = "p_id_condutor")
	private String id_condutor;
	
	public void setHeader_text(String header_text){
		this.header_text = header_text;
	}
	public String getHeader_text(){
		return this.header_text;
	}
	
	public void setCondutor(String condutor){
		this.condutor = condutor;
	}
	public String getCondutor(){
		return this.condutor;
	}
	
	public void setVeiculo(String veiculo){
		this.veiculo = veiculo;
	}
	public String getVeiculo(){
		return this.veiculo;
	}
	
	public void setData_saida(String data_saida){
		this.data_saida = data_saida;
	}
	public String getData_saida(){
		return this.data_saida;
	}
	
	public void setHora(String hora){
		this.hora = hora;
	}
	public String getHora(){
		return this.hora;
	}
	
	public void setKm_saida(double km_saida){
		this.km_saida = km_saida;
	}
	public double getKm_saida(){
		return this.km_saida;
	}
	
	public void setId_condutor(String id_condutor){
		this.id_condutor = id_condutor;
	}
	public String getId_condutor(){
		return this.id_condutor;
	}



}
