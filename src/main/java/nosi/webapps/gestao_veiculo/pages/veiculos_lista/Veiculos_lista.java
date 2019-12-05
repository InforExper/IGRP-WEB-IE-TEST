package nosi.webapps.gestao_veiculo.pages.veiculos_lista;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

public class Veiculos_lista extends Model{		

	@RParam(rParamName = "p_sectionheader_1_text")
	private String sectionheader_1_text;
	
	public void setSectionheader_1_text(String sectionheader_1_text){
		this.sectionheader_1_text = sectionheader_1_text;
	}
	public String getSectionheader_1_text(){
		return this.sectionheader_1_text;
	}



}
